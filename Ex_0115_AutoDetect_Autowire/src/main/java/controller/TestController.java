package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.TotalService;
import vo.DeptVO;
import vo.SawonVO;

@Controller
public class TestController {

	TotalService service;

	@Autowired
	public TestController(TotalService service) {
		this.service = service;
		System.out.println("--TestController의 생성자--");
	}

	@RequestMapping(value = { "/", "/list.do" })
	public String dept_list(Model model) {
		List<DeptVO> dept_list = service.selectList_dept();
		List<SawonVO> sawon_list = service.selectList_sawon();

		model.addAttribute("list", dept_list);
		model.addAttribute("list2",sawon_list);
		return "total_list";
	}

}
