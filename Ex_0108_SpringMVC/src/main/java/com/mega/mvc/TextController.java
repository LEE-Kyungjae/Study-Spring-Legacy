package com.mega.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TextController {
	// 실행경로를 참조할 상수값
	public static final String VIEW_PATH = "/WEB-INF/views/";

	public TextController() {
		System.out.println("--테스트 컨트롤러 기본 생성자--");
	}

	@RequestMapping(value = { "/", "/dept.do" })
	public String test(Model model, HttpServletRequest request) {
		String[] msg = { "안녕하세요", "hello", "니하오" };
		String ip = request.getRemoteAddr();
		//model.addAttribute("msg", msg);
		//model.addAttribute("ip", ip);
		request.setAttribute("msg", msg);
		request.setAttribute("ip", ip);
		return VIEW_PATH + "dept/dept.jsp";
	}

	@RequestMapping("/sawon.do")
	public String test2() {
		return VIEW_PATH + "sawon/sawon.jsp";
	}
}