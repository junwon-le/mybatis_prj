package day1222;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import day1219.DeptDTO;
import kr.co.sist.dao.MyBatisHandler;

public class TestMyBatis2 {

	public static void main(String[] args) {

		
		//1. MyBatis Handler 얻기 
		SqlSession ss= MyBatisHandler.getInstance().getMyBatisHandler(false);
		
		//2. 사용할 쿼리문(mapper.xml)을 찾아서 실행
		List<DeptDTO> list = ss.selectList("day1219.selectDept");
		
		
		//3. 결과 얻기 
		for(DeptDTO dd : list) {
			System.out.println(dd.getDeptno()+" / "+dd.getDname()+" / "+dd.getLoc());
			
		}//end for
		
		
		//4. MyBatis Handler 닫기
		if(ss!=null) {ss.close();}//end if
		
	}//main
}//class
