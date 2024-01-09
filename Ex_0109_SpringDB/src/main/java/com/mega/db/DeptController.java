package com.mega.db;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDAO;
import vo.DeptVO;

@Controller
public class DeptController {

	DeptDAO dept_dao;

	public DeptController(DeptDAO dept_dao) {
		this.dept_dao = dept_dao;
	}

	@RequestMapping(value = { "/", "/list.do" })
	public String dList(Model model) {
		// dao에게 부서목록을 요청
		List<DeptVO> list = dept_dao.selectList();

		model.addAttribute("list", list);

		return "/WEB-INF/views/dept_list.jsp";
	}

}
