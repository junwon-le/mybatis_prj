package kr.co.sist.car;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class carSearchService {
	private static carSearchService css;
	
	private carSearchService() {
	}
	
	public static carSearchService getInstance() {
		if(css==null) {
			css = new carSearchService();
		}//end if
		return css;
	}//getInstance
	
	
	
	public String searchMaker(String country){
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("result", false);
		jsonObj.put("makerCnt", 0);
		
		carSearchDAO csDAO = carSearchDAO.getInstance();
		try {
		List<String> makerList = csDAO.selectMaker(country);
		jsonObj.put("result",true);
		jsonObj.put("makerCnt", makerList.size());
		
		JSONObject jsonTemp = null;
		JSONArray jsonArr = new JSONArray();
		
		for(String maker: makerList) {
			jsonTemp = new JSONObject();
			
			jsonTemp.put("maker", maker);
			
			jsonArr.add(jsonTemp);
		}
		
		jsonObj.put("data", jsonArr);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return jsonObj.toJSONString();
	}
	public String searchModel(String maker){
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("result", false);
		jsonObj.put("modelCnt", 0);
		
		carSearchDAO csDAO = carSearchDAO.getInstance();
		try {
			List<String> modelList = csDAO.selectModel(maker);
			jsonObj.put("result",true);
			jsonObj.put("modelCnt", modelList.size());
			
			JSONObject jsonTemp = null;
			JSONArray jsonArr = new JSONArray();
			
			for(String model: modelList) {
				jsonTemp = new JSONObject();
				
				jsonTemp.put("model", model);
				
				jsonArr.add(jsonTemp);
			}
			
			jsonObj.put("data", jsonArr);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return jsonObj.toJSONString();
	}
	public String searchCar(String model){
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("result", false);
		jsonObj.put("carCnt", 0);
		
		carSearchDAO csDAO = carSearchDAO.getInstance();
		try {
			List<carDomain> carList = csDAO.selectCar(model);
			jsonObj.put("result",true);
			jsonObj.put("carCnt", carList.size());
			
			JSONObject jsonTemp = null;
			JSONArray jsonArr = new JSONArray();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm");
			String carOption = "";
			for(carDomain cmd: carList) {
				
				carOption = cmd.getCar_option();
				if( carOption != null && carOption.length() > 20) {
					carOption=carOption.substring(0,19)+"...";
				}
				
				jsonTemp = new JSONObject();
				
				jsonTemp.put("car_img", cmd.getCar_img());
				jsonTemp.put("car_option", carOption);
				jsonTemp.put("car_year", cmd.getCar_year());
				jsonTemp.put("price", cmd.getPrice());
				jsonTemp.put("cc", cmd.getCc());
				jsonTemp.put("input_date", sdf.format(cmd.getInput_date()));
				
				jsonArr.add(jsonTemp);
			}
			
			jsonObj.put("data", jsonArr);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return jsonObj.toJSONString();
	}
	
	
// ====================내가 한거 =====================================	
	
	
	public List<String> carTypeSearch(String brand){
		List<String> carList = null;
		carSearchDAO csDAO = carSearchDAO.getInstance();
		carList = csDAO.selectModel(brand);
		
		return carList;
	}
	public List<carDomain> carSearch(String brand){
		List<carDomain> carList = null;
		carSearchDAO csDAO = carSearchDAO.getInstance();
		carList = csDAO.selectCar(brand);
		
		return carList;
	}
	
	
}
