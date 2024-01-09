package service;

import java.util.List;

import dao.FruitDAO;
//DB통신을 마친 DAO들을 하나로 묶어서 관리하기 위한 클래스
public class FruitService {
	//BoardDAO b_dao;
	FruitDAO dao;
	
	public FruitService() {
		// TODO Auto-generated constructor stub
	}
	
	public FruitService(FruitDAO dao) {
		this.dao = dao;
	}
	
	public List<String> selectList(){
		return dao.selectList();
	}

	public FruitDAO getDao() {
		return dao;
	}

	public void setDao(FruitDAO dao) {
		this.dao = dao;
	}
	
}
