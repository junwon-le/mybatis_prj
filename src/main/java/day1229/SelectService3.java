package day1229;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import day1226.CarModelDomain;
import day1226.EmpDomain;
import kr.co.sist.dao.myBatiseHandler;

public class SelectService3 {
	private static SelectService3 ss;
	
	private SelectService3() {
		
	}
	
	public static SelectService3 getInstance() {
		if(ss==null) {
			ss = new SelectService3();
		}//end if
		return ss;
	}//getInstance
	
	
	public List<CarModelDomain> subNjoin(){
		List<CarModelDomain> carList = null;
		SelectDAO3 sDAO3 = SelectDAO3.getInstance();
		try {
			carList = sDAO3.subqueryNjoin();
		}catch(PersistenceException pe) {
		}
		return carList;
	}//greaterThan
	
	public List<EmpDomain> dollar(String tableName) throws PersistenceException {
		List<EmpDomain> empList = null;
		
		SelectDAO3 sDAO3 = SelectDAO3.getInstance();
		try {
			empList = sDAO3.dollar(tableName);
		}catch(PersistenceException pe) {
		}
		
		return empList;
	}//dollar
	public List<EmpDomain> dynamicIf(int deptno) throws PersistenceException {
		List<EmpDomain> empList = null;
		
		if(deptno != 10 && deptno != 20 && deptno != 30 && deptno != 40  ) {
			deptno = 0;
		}
		
		SelectDAO3 sDAO3 = SelectDAO3.getInstance();
		try {
			empList = sDAO3.dynamicIf(deptno);
		}catch(PersistenceException pe) {
		}
		return empList;
	}//dynamicIf
}
