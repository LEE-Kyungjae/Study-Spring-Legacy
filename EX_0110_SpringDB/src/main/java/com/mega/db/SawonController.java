package com.mega.db;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.SawonDAO;
import vo.SawonVO;

@Controller
public class SawonController {
	SawonDAO sawon_dao;
	static String PATH = "/WEB-INF/views/";

	public SawonController(SawonDAO dao) {
		this.sawon_dao = dao;
	}

	@RequestMapping(value = { "/", "/sawon.do" })
	public String Sawon(Model model) {
		List<SawonVO> list = sawon_dao.selectAll();
		model.addAttribute("list", list);

		return PATH + "sawon.jsp";
	}
}