package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.SawonVO;

@Repository("sawon_dao")
public class SawonDAO {

	SqlSession sqlSession;

	@Autowired
	public SawonDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		System.out.println("--SawonDAO의 생성자--");
	}

	public List<SawonVO> selectList() {
		List<SawonVO> list = sqlSession.selectList("s.sawon_list");
		return list;
	}
}
