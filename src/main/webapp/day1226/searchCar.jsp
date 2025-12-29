<%@page import="kr.co.sist.car.carSearchService"%>
<%@page import="day1226.CarModelDomain"%>
<%@page import="day1226.EmpDomain"%>
<%@page import="day1226.SelectService2"%>
<%@page import="day1224.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="day1224.SelectService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h3>차량 검색</h3>
<script>
	$(function(){
		$("#nation").change(function(){
			if($(this).val()=="국산"){
				
			var sel = $("#brand")[0];
			sel.length = 1;
			var jsonArr = [{brand:"기아", value:"기아"},{brand:"쌍용", value:"쌍용"},{brand:"삼성", value:"삼성"}];
			$.each(jsonArr,function(i,ele){
				sel.options[i+1] = new Option(ele.brand,ele.value);
			})
			}
			else if($(this).val()=="수입"){
			var sel = $("#brand")[0];
			sel.length = 1;
			var jsonArr = [{brand:"BMW", value:"BMW"},{brand:"AUDI", value:"AUDI"},{brand:"BENZ", value:"BENZ"}];
			$.each(jsonArr,function(i,ele){
				sel.options[i+1] = new Option(ele.brand,ele.value);
			})
			}else{
			var sel = $("#brand")[0];
			sel.length = 1;
			}
			
		});//nation
		
		
		$("#brand").change(function(){
			var param = {"brand":$(this).val()};
			$.ajax({
				url:"brandSearch.jsp",
				type : "get" ,
				data : param,
				dataType:"json",
				error: function(xhr, status, err) {
				    // 알림창에 404가 뜨면 경로 문제, 500이 뜨면 JSP 자바 소스 문제입니다.
				    alert("상태: " + xhr.status + "\n메시지: " + xhr.responseText);
				    
				},
				success:function(jsonArr){
					var sel = $("#carType")[0];
					sel.length=1;
					$.each(jsonArr, function(i,ele){
						sel.options[i+1]= new Option(ele.carType);
					})
				}
			})
		});//nation
		
		$("#btn").click(function(){
			var param = {"carType":$("#carType").val()};
			$.ajax({
				url:"carSearch.jsp",
				type : "get" ,
				data : param,
				dataType:"json",
				error: function(xhr, status, err) {
				    // 알림창에 404가 뜨면 경로 문제, 500이 뜨면 JSP 자바 소스 문제입니다.
				    alert("상태: " + xhr.status + "\n메시지: " + xhr.responseText);
				    
				},
				success:function(jsonArr){
					output = "";
					$.each(jsonArr, function(i,car){
					output += `<tr>
						<td><img src="images/car_img/${car.img}" style="width: 80px; height: 60px;"/></td>
						<td>${car.model}</td>
						<td>${car.year}</td>
						<td>${car.price}</td>
						<td>${car.cc}</td>
						<td>${car.input_date}</td>
					</tr>`						
					})
					$("#car tbody").empty();
					$("#car tbody").append(output);	
					
				}
			})
		});//nation
		
		
		
	
	});
</script>
<form id="carSearch">
<select id="nation" style="width:150px;">
<option value="N/A">--선택--</option>
<option value="국산">국산</option>
<option value="수입">수입</option>
</select>
<select id="brand" name="brand" style="width:150px;">
</select>

<select id="carType" style="width:150px;">
</select>
<input type="button" value="검색" id="btn" class="btn btn-info btn-sm"/>
</form>
<div id="output">
	<%
	%>
	<table class="table table-hover" id="car">
	<tr>
	<th>이미지</th>
	<th>모델명</th>
	<th>년식</th>
	<th>가격</th>
	<th>배기량</th>
	<th>입력일</th>	
	</tr>
	<tbody>
	<c:if test="${empty carList}">
		<tr >
		<td colspan="7" style="text-align: center;"><img src="images/na.jpg" style="width: 300px; height 260px;"/> </td>
		</tr>
	</c:if>
	<c:if test="${not empty carList }">
	</c:if>
	</tbody>
	</table> 
	</div>
