package dao;

import java.util.ArrayList;
import java.util.List;

import vo.FruitVO;

public class FruitDAO {
	
	public List<FruitVO> selectAll(){
		FruitVO v1 = new FruitVO();
		v1.setName("사과");
		v1.setAge(10);
		
		FruitVO v2 = new FruitVO();
		v2.setName("오렌지");
		v2.setAge(25);
		
		List<FruitVO> list = new ArrayList<FruitVO>();
		list.add(v1);
		list.add(v2);
		
		return list;
	}
}
