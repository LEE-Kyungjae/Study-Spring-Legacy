package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVO;

public class VisitDAO {
	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 방명록 전체 조회
	public List<VisitVO> selectAll() {
		List<VisitVO> list = sqlSession.selectList("v.visit_list");
		return list;
	}

	// 새 글 쓰기
	public int insert(VisitVO vo) {

		int res = sqlSession.insert("v.visit_insert", vo);
		return res;

	}

	// 글 삭제
	public int delete(int idx) {
		int res = sqlSession.delete("v.visit_delete", idx);
		return res;
	}

	// 글 수정 폼
	public VisitVO selectOne(int idx) {
		VisitVO vo = sqlSession.selectOne("v.visit_one", idx);
		return vo;
	}

	public int update(VisitVO vo) {
		int res = sqlSession.update("v.visit_update", vo);
		return res;
	}
}
