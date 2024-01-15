package com.mega.vs;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.VisitDAO;
import util.MyCommon;
import vo.VisitVO;

@Controller
public class VisitController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;
	@Autowired
	ServletContext app;

	VisitDAO visitDao;

	public void setVisitDao(VisitDAO visitDao) {
		this.visitDao = visitDao;
	}

	@RequestMapping(value = { "/", "/list.do" })
	public String listAll(Model model) {
		List<VisitVO> list = visitDao.selectAll();
		model.addAttribute("list", list);
		return MyCommon.Visit.VIEW_PATH + "visit_list.jsp";
	}

	// 새글쓰기 폼 띄우기
	@RequestMapping("/insert_form.do")
	public String insert_form() {
		return MyCommon.Visit.VIEW_PATH + "visit_insert_form.jsp";
	}

	// 새 글 쓰기
	@RequestMapping("/insert.do")
	public String insert(VisitVO vo) {

		String ip = request.getRemoteAddr();// ip가져오기

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodePwd = encoder.encode(vo.getPwd());
		vo.setPwd(encodePwd);
		vo.setIp(ip);
		// System.out.println( "암호화 : " + encodePwd );

		// 절대경로로 사용할 path
		String webPath = "/resources/upload/";
		// 실제 절대경로로 변환된 path
		String savePath = app.getRealPath(webPath);
		System.out.println("절대경로 : " + savePath);
		// 업로드 된 파일 정보
		MultipartFile photo = vo.getPhoto();
		String filename = "no_file";

		// 업로드된 파일의 존재여부 확인
		if (!photo.isEmpty()) {
			filename = photo.getOriginalFilename();// 원본 파일명
			File saveFile = new File(savePath, filename);
			if (!saveFile.exists()) {
				saveFile.mkdirs();
			} else {
				// 업로드된 파일명의 중복처리
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time, filename);
				saveFile = new File(savePath, filename);
			}
			// 지정된 경로로 파일을 물리적으로 복사
			try {
				photo.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // if
		vo.setFilename(filename);

		// 새글 작성
		visitDao.insert(vo);

		return "redirect:list.do";

	}

	@RequestMapping("/delete.do")
	@ResponseBody // return값을 view로 인식하지 말고 콜백메서드로 보내라
	// Ajax로 url매핑을 요청받았다면 반드시 필요한 어노테이션
	public String delete(int idx, String pwd, String c_pwd) {
		// 입력받은 비밀번호와 암호화된 비밀번호의 체크
		boolean isCheck = BCrypt.checkpw(pwd, c_pwd);

		if (!isCheck) {
			return "3";
		}
		int res = visitDao.delete(idx);
		System.out.println(res);
		if (res >= 1) {
			return "1";
		} else {
			return "0";
		}
	}

	// 수정폼으로 이동
	@RequestMapping("/modify_form.do")
	@ResponseBody
	public String modify_form(int idx, String pwd, String c_pwd) {

		boolean check = BCrypt.checkpw(c_pwd, pwd);
		if (!check) {
			return "3";
		}
		VisitVO vo = visitDao.selectOne(idx);
		if (vo != null) {
			session.setAttribute("vo", vo);
			return "1";
		} else {
			return "0";
		}
	}

	// 실제 수정페이지 화면 전환
	@RequestMapping("/modify.do")
	public String modify() {
		return MyCommon.Visit.VIEW_PATH + "visit_modify_form.jsp";
	}

	// 수정작업 수행
	@RequestMapping("/modify_fin.do")
	public String modify_fin(VisitVO vo) {
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String pwd = encoder.encode(vo.getPwd());
		vo.setPwd(pwd);
		visitDao.update(vo);
		return "redirect:list.do";
	}
}