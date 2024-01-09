package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.FruitService;

// @ : 어노테이션(프로그래밍 주석) - 컴파일러가 정보를 캐치하여 빠르게 작업을 수행하고자 하는 목적
// 특수한 기능으롰 동작하게 만들기 위한 용도
@Controller	//<--컨트롤러를 생성할때는 반드시 @controller 어노테이션이 필요하다
public class FruitController {
	FruitService service;

	public FruitController() {
		System.out.println("--FruitController생성됨--");
	}
	public void setService(FruitService service) {
		this.service = service;
		System.out.println("--FruitService의 셋터--");
	}
	//호출될 url매핑 지정
	@RequestMapping("/list.do")
	public String list(Model model) {
		//list.do 가 호출되면 현재 메서드가 동작
		List<String>list=service.selectList();
		
		//model:request에서 바인딩 관련 기능만을 가지고 있는 경량의 클래스
		model.addAttribute("list",list);
		
		return "board_list";//board_list.jsp로 포워딩
	}
}