<%@page import="day1226.EmpDomain"%>
<%@page import="day1226.SelectService2"%>
<%@page import="day1224.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="day1224.SelectService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h3>subquery의 조회</h3>
<script>
	$(function(){
		$("#btn").click(function(){
			$("#frm").submit()
		});
	});
</script>
최근 신입 사원 검색.<br>
<div id="output">
	<%
	SelectService2 ss2 = SelectService2.getInstance();
	List<EmpDomain> empList = ss2.subquery();
	
	pageContext.setAttribute("empList", empList);
	%>
	<table class="table table-hover">
	<tr>
	<th>사원번호</th>
	<th>사원명</th>
	<th>연봉</th>
	<th>입사일</th>
	</tr>
	<c:if test="${empty empList}">
		<tr >
		<td colspan="4" style="text-align: center;"><img src="images/na.jpg" style="width: 300px; height 260px;"/> </td>
		</tr>
	</c:if>
	<c:if test="${not empty empList }">
	<c:forEach var="emp" items="${empList }" varStatus="i">
	<tr>
		<td><c:out value="${emp.empno }"/></td>
		<td><c:out value="${emp.ename}"/></td>
		<td><c:out value="${emp.sal}"/></td>
		<td><c:out value="${emp.hiredate}"/></td>
		<td><fmt:formatDate pattern="yyyy-MM-dd EEEE" value="${ emp.hiredate}"/></td>
	</tr>
	</c:forEach>
	</c:if>
	</table> 
	
	</div>
