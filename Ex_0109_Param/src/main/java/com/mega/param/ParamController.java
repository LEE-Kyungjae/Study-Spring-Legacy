package com.mega.param;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vo.PersonVO;

@Controller
public class ParamController {
	public static final String VIEW_PATH = "/WEB-INF/views/person/";
	
	@RequestMapping(value= {"/","/insert_form.do"})
	public String insert_form() {
		return VIEW_PATH + "insert_form.jsp"; 
	}
	@RequestMapping("/insert1.do")
	public String insert1(Model model, String name, int age, String addr) {
		PersonVO vo = new PersonVO();
		//name, age, addr이라는 이름으로 전달된 값을
		//현재 메서드의 파라미터가 순차적으로 받는다(자동)
		vo.setName(name);
		vo.setAge(age);
		vo.setAddr(addr);
		model.addAttribute("vo", vo);
		return VIEW_PATH + "insert_result.jsp";
	}
	//insert2.do?name=홍길동 &age=20 &addr=서울시+관악구
	@RequestMapping("/insert2.do")
	public String insert2(Model model,PersonVO vo) {
		//파라미터로 넘어온 값을 vo에 속성(변수명)이 일치하는 곳에 자동으로 추가
		model.addAttribute("vo",vo);
		//insert2(Model model, PersonVO vo, String name)
		//위와 같이 vo에 이미 존재하는 변수를 파라미터로 또 받으면 실행시 오류 발생
		return VIEW_PATH +"insert_result.jsp";
		
	}
}
