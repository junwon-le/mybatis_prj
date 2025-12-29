<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap CDN 시작 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
<!-- jQuery CDN 시작 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn").click(function(){
			//1. 옵션을 생성할 select을 얻기
			var sel = $("#sel")[0];
			sel.length=1; //남겨둘 옵션의 수
			//2. 선택한 select에서 옵션을 생성
			var jsonArr = [{name:"민병조", age:25},{name:"임성우", age:26},{name:"박현욱", age:27}]
			$.each(jsonArr, function(i,ele){
			sel.options[i+1] = new Option(ele.name,ele.age);
			})
		});//click
		
		$("#btn2").click(function(){
			//1. 옵션을 생성할 select을 얻기
			var sel = $("#sel")[0];
			sel.length=0; //남겨둘 옵션의 수
			//alert( "sel의 옵션의 개수:"+sel.length );
			//2. 선택한 select에서 옵션을 생성
			var jsonArr = [{name:"탄지로", age:17},{name:"덴지", age:20},{name:"루피", age:30},{name:"이치로	", age:30},{name:"나루토", age:36}]
			
			$.each(jsonArr, function(i,ele){
			sel.options[i+1] = new Option(ele.name,ele.age);
			})
		});//click
	})
</script>
</head>
<body>
<select id=sel>
<option value="N/A">----선택 하세요 -------</option>
</select>
<input type="button" value="채우기" id="btn" class="btn btn-info btn-sm"/>
<input type="button" value="채우기2" id="btn2" class="btn btn-info btn-sm"/>
</body>
</html>