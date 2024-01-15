package com.mega.jm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.PersonVO;

@Controller
public class JsonMakerController {

	@RequestMapping(value = { "/", "list.do" })
	public String selectList() {
		return "WEB-INF/views/first.jsp";
	}

	@RequestMapping("/vo_json.do")
	@ResponseBody
	public PersonVO voToJson() {
		PersonVO p = new PersonVO();
		p.setAddr("서울시 관악구");
		p.setAge(20);
		p.setName("홍길동");

		return p;
	}
}