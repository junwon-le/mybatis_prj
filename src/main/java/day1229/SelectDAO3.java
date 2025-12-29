package day1229;


import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import day1226.CarModelDomain;
import day1226.EmpDomain;
import kr.co.sist.dao.myBatiseHandler;

public class SelectDAO3 {
	private static SelectDAO3 sDAO;

	private SelectDAO3() {
	}// SelectDAO

	public static SelectDAO3 getInstance() {
		if (sDAO == null) {
			sDAO = new SelectDAO3();

		} // end if
		return sDAO;
	}// getInstance
	
	public List<CarModelDomain> subqueryNjoin() throws PersistenceException {
		List<CarModelDomain> carList = null;
		SqlSession ss = myBatiseHandler.getInstance().getMyBatisHandler(false);
		carList = ss.selectList("day1229.subNjoin");
		if (ss != null) {ss.close();}
		return carList;
	}//subqueryNjoin
	
	public List<EmpDomain> dollar(String tableName) throws PersistenceException {
		List<EmpDomain> empList = null;
		SqlSession ss = myBatiseHandler.getInstance().getMyBatisHandler(false);
		empList = ss.selectList("day1229.dollar",tableName);
		if (ss != null) {ss.close();}
		return empList;
	}//dollar
}

