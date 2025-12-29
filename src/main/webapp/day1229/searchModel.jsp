<%@page import="kr.co.sist.car.carSearchService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
    
  
<%String maker = request.getParameter("maker");
if(maker == null){
	maker="현대";
}
out.print(carSearchService.getInstance().searchModel(maker));
%>    
