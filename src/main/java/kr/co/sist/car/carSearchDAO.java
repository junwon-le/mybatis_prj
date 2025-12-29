package kr.co.sist.car;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.myBatiseHandler;

public class carSearchDAO {
	private static carSearchDAO cDAO;

	private carSearchDAO() {
	}// SelectDAO

	public static carSearchDAO getInstance() {
		if (cDAO == null) {
			cDAO = new carSearchDAO();

		} // end if
		return cDAO;
	}// getInstance
	
	public List<String> selectMaker(String country) throws PersistenceException{
		List<String> makerList = null;
		SqlSession ss = myBatiseHandler.getInstance().getMyBatisHandler(false);

		makerList = ss.selectList("kr.co.sist.car.selectMaker",country);
		
		return makerList;
	}
	
	public List<String> selectModel(String brand) throws PersistenceException {
		List<String> carList= null;
		
		SqlSession ss = myBatiseHandler.getInstance().getMyBatisHandler(false);
		carList = ss.selectList("kr.co.sist.car.selectModel",brand);
		
		return carList;
	}//selectModel

	public List<carDomain> selectCar(String model) throws PersistenceException {
		List<carDomain> modelList= null;
		
		SqlSession ss = myBatiseHandler.getInstance().getMyBatisHandler(false);
		modelList = ss.selectList("kr.co.sist.car.selectCar",model);
		
		return modelList;
	}
}
