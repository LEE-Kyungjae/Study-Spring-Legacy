package dao;

import java.util.ArrayList;
import java.util.List;

public class FruitDAO {

	//목록조회용 메서드
	public List<String> selectList(){
		
		//DB에서 과일목록을 가져왔다고 가정
		List<String> list =new ArrayList<String>();
		list.add("사과");
		list.add("수박");
		list.add("딸기");
		list.add("바나나");
		
		return list;
		
	}
	
}
