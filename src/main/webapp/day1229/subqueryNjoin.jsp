<%@page import="day1226.CarModelDomain"%>
<%@page import="day1229.SelectService3"%>
<%@page import="day1226.EmpDomain"%>
<%@page import="day1226.SelectService2"%>
<%@page import="day1224.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="day1224.SelectService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h3>subquery / join의 조회</h3>
<script>
	$(function(){
		
	});
</script>
보유중인 국산 차량의 최신 10건 검색.<br>
<div id="output">
	<%
	SelectService3 ss3 = SelectService3.getInstance();
	List<CarModelDomain> carList = ss3.subNjoin();
	
	pageContext.setAttribute("carList", carList);
	%>
	<table class="table table-hover">
	<tr>
	<th>이미지</th>
	<th>제조국</th>
	<th>제조사</th>
	<th>모델명</th>
	<th>년식</th>
	<th>가격</th>
	<th>배기량</th>
	<th>입력일</th>
	</tr>
	<c:if test="${empty carList}">
		<tr >
		<td colspan="8" style="text-align: center;"><img src="images/na.jpg" style="width: 300px; height 260px;"/> </td>
		</tr>
	</c:if>
	<c:if test="${not empty carList }">
	<c:forEach var="car" items="${carList }" varStatus="i">
	<tr>
		<td><img src="images/car_img/${car.car_img}" style="width:80px; height:60px;"/></td>
		<td><c:out value="${car.country}"/></td>
		<td><c:out value="${car.maker}"/></td>
		<td><c:out value="${car.model}"/></td>
		<td><c:out value="${car.car_year}"/></td>
		<td><c:out value="${car.price}"/></td>
		<td><c:out value="${car.cc}"/></td>
		<td><c:out value="${car.input_date}"/></td>
	</tr>
	</c:forEach>
	</c:if>
	</table> 
	
	</div>
