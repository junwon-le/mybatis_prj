<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="kr.co.sist.car.carSearchService"%>
<%@page import="kr.co.sist.car.carDomain"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<% 
	String carType = request.getParameter("carType");
	System.out.println(carType);
	
	
	carSearchService css = carSearchService.getInstance();
	List<carDomain> carList = css.carSearch(carType);
	JSONArray jsonArr = new JSONArray();
	
	for(carDomain ele : carList){
	JSONObject jsonObj = new JSONObject();
	
	jsonObj.put("model",ele.getModel());
	jsonObj.put("year",ele.getCar_year());
	jsonObj.put("price",ele.getPrice());
	jsonObj.put("cc",ele.getCc());
	jsonObj.put("img",ele.getCar_img());
	jsonObj.put("input_date",ele.getInput_date()); 

	jsonArr.add(jsonObj);
	} 
	
	
	out.print(jsonArr.toJSONString());
	
 %>