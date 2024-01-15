package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.DeptVO;

@Repository("dept_dao")
public class DeptDAO {

	SqlSession sqlSession;

	@Autowired
	public DeptDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		System.out.println("--DeptDAO의 생성자--");
	}

	public List<DeptVO> selectList() {
		List<DeptVO> list = sqlSession.selectList("d.dept_list");
		return list;
	}

}
