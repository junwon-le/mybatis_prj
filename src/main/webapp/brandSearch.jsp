<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="kr.co.sist.car.carSearchService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<% 
	String brand = request.getParameter("brand");
	System.out.println(brand);
	
	
	carSearchService css = carSearchService.getInstance();
	List<String> carList = css.carTypeSearch(brand);
	JSONArray jsonArr = new JSONArray();
	
	for(String ele : carList){
	JSONObject jsonObj = new JSONObject();
	
	jsonObj.put("carType",ele);
	jsonArr.add(jsonObj);
	}
	
	out.print(jsonArr.toJSONString());
	
 %>