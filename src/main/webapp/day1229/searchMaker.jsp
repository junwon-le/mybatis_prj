<%@page import="kr.co.sist.car.carSearchService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
    
<%String country = request.getParameter("country");
if(country == null){
	country="국산";
}
out.print(carSearchService.getInstance().searchMaker(country));
%>    
