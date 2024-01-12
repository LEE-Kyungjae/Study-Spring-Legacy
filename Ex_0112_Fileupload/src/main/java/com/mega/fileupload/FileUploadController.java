package com.mega.fileupload;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import vo.PhotoVO;

@Controller
public class FileUploadController {

	// @Autowired : 자동주입
	@Autowired
	ServletContext app;

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;

	public static final String VIEW_PATH = "/WEB-INF/views/";
	// 파일을 포함하는 입력 폼 호출

	@RequestMapping(value = { "/", "/insert_form.do" })
	public String insert_form() {
		return VIEW_PATH + "insert_form.jsp";
	}

	// 파일 업로드
	// upload.do?title=제목&photo=#%#&!
	@RequestMapping("/upload.do")
	public String upload(PhotoVO vo, Model model) {
		// servive.
		// session.setAttribute();
		// request.getRemoteAddr(VIEW_PATH,vo);

		String webPath = "/resources/upload/";
		String savePath = app.getRealPath(webPath);
		System.out.println("절대경로" + savePath);
		// 업로드된 파일의 정보
		MultipartFile photo = vo.getPhoto();

		String filename = "no_file";

		if (!photo.isEmpty()) {
			filename = photo.getOriginalFilename();// 업로드 된 실제 파일명(a.jpg)
			File saveFile = new File(savePath, filename);
			if (!saveFile.exists()) {
				saveFile.mkdirs();
			} else {
				// 파일이름이 중복되지 않게 변경
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time, filename);
				saveFile = new File(savePath, filename);
			}
			try {
				// 임시저장소에 있던 파일정보를 내가 지정해둔 경로로 물리적으로 복사
				photo.transferTo(saveFile);
			} catch (Exception e) {
			}
		} // if
		vo.setFilename(filename);
		model.addAttribute("vo",vo);
		return "";
	}

}
