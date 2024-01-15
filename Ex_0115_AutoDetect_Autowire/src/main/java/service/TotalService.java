package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DeptDAO;
import dao.SawonDAO;
import vo.DeptVO;
import vo.SawonVO;

@Service
public class TotalService {

	DeptDAO dept_dao;// @Repository("dept_dao") <-이름이 같아야 한다
	SawonDAO sawon_dao;

//	@Autowired
//	public void setSawon_dao(SawonDAO sawon_dao) {
//		this.sawon_dao = sawon_dao;
//		System.out.println("--setSawon_dao--");
//	}

	@Autowired
	public TotalService(DeptDAO dept_dao, SawonDAO sawon_dao) {
		this.dept_dao = dept_dao;
		this.sawon_dao = sawon_dao;
		System.out.println("--TotalService의 생성자--");
	}

	public List<DeptVO> selectList_dept() {
		List<DeptVO> list = dept_dao.selectList();
		return list;
	}

	public List<SawonVO> selectList_sawon() {
		List<SawonVO> list = sawon_dao.selectList();
		return list;
	}
}