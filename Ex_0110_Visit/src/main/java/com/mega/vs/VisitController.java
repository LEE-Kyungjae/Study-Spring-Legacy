package com.mega.vs;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.VisitDAO;
import util.MyCommon;
import vo.VisitVO;

@Controller
public class VisitController {
	VisitDAO visitDao;
	
	public void setVisitDao(VisitDAO visitDao) {
		this.visitDao = visitDao;
	}
	
	@RequestMapping(value = {"/","/list.do"})
	public String listAll(Model model) {
		List<VisitVO> list=visitDao.selectAll();
		model.addAttribute("list", list);
		return MyCommon.Visit.VIEW_PATH+"visit_list.jsp";
	}
}
