package com.mega.vs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.VisitDAO;
import util.MyCommon;
import vo.VisitVO;

@Controller
public class VisitController {
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
	public String insert(VisitVO vo, HttpServletRequest request) {

		String ip = request.getRemoteAddr();// ip가져오기

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodePwd = encoder.encode(vo.getPwd());
		vo.setPwd(encodePwd);
		vo.setIp(ip);
		// System.out.println( "암호화 : " + encodePwd );

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
	public String modify_form(HttpSession session, int idx, String pwd, String c_pwd) {

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
	public String modify_fin(VisitVO vo, HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String pwd = encoder.encode(vo.getPwd());
		vo.setPwd(pwd);
		visitDao.update(vo);
		return "redirect:list.do";
	}
}
