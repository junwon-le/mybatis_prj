package day1226;


import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.myBatiseHandler;

public class SelectDAO2 {
	private static SelectDAO2 sDAO;

	private SelectDAO2() {
	}// SelectDAO

	public static SelectDAO2 getInstance() {
		if (sDAO == null) {
			sDAO = new SelectDAO2();

		} // end if
		return sDAO;
	}// getInstance

	/**
	 * 사원 번호와 부서 번호에 대한 사원 정보 조회
	 * 
	 * @param deptno
	 * @return
	 * @throws PersistenceException
	 */
	public EmpDomain useDomain(EmpDTO empDTO) throws PersistenceException {
		EmpDomain empDomain = null;
		SqlSession ss = myBatiseHandler.getInstance().getMyBatisHandler(false);
		empDomain = ss.selectOne("day1226.useDomain", empDTO);
		if (ss != null) {ss.close();}
		return empDomain;
	}//useDomain
	
	public List<ZipCodeDomain> useLike(String dong) throws PersistenceException {
		List<ZipCodeDomain> zipList = null;
		SqlSession ss = myBatiseHandler.getInstance().getMyBatisHandler(false);
		zipList = ss.selectList("day1226.like", dong);
		if (ss != null) {ss.close();}
		return zipList;
	}//useDomain
	
	public List<EmpDomain> lessThan(int sal) throws PersistenceException {
		List<EmpDomain> empList = null;
		SqlSession ss = myBatiseHandler.getInstance().getMyBatisHandler(false);
		empList = ss.selectList("day1226.lessThan", sal);
		if (ss != null) {ss.close();}
		return empList;
	}//lessThan
	public List<EmpDomain> greaterThan(int sal) throws PersistenceException {
		List<EmpDomain> empList = null;
		SqlSession ss = myBatiseHandler.getInstance().getMyBatisHandler(false);
		empList = ss.selectList("day1226.greaterThan", sal);
		if (ss != null) {ss.close();}
		return empList;
	}//greaterThan
	public List<EmpDomain> subquery() throws PersistenceException {
		List<EmpDomain> empList = null;
		SqlSession ss = myBatiseHandler.getInstance().getMyBatisHandler(false);
		empList = ss.selectList("day1226.subquery");
		if (ss != null) {ss.close();}
		return empList;
	}//greaterThan
	
	public List<EmpDomain> union() throws PersistenceException {
		List<EmpDomain> empList = null;
		SqlSession ss = myBatiseHandler.getInstance().getMyBatisHandler(false);
		empList = ss.selectList("day1226.union");
		if (ss != null) {ss.close();}
		return empList;
	}//union
	
	public List<CarModelDomain> join() throws PersistenceException {
		List<CarModelDomain> carList = null;
		SqlSession ss = myBatiseHandler.getInstance().getMyBatisHandler(false);
		carList = ss.selectList("day1226.join");
		if (ss != null) {ss.close();}
		return carList;
	}//join
}

