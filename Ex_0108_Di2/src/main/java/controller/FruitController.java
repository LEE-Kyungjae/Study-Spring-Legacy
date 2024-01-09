package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.FruitDAO;
import vo.FruitVO;

@Controller
public class FruitController {
	FruitDAO dao;
	
	public FruitController(FruitDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/flist.do")
	public String fList(Model model) {
		List<FruitVO> list = dao.selectAll();
		
		model.addAttribute("list",list);
		
		return "flist"; 
	}
}
