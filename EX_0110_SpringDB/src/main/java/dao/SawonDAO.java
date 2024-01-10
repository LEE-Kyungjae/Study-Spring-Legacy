package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.SawonVO;

public class SawonDAO {
	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<SawonVO> selectAll() {
		List<SawonVO> list = sqlSession.selectList("s.sawon_list");
		return list;
	}
}
