<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터를 공유해서 출력</title>
</head>
<body>
<%
     //request.setAttribute("result", resultObject);
     //${키명}=request.getAttribute("키명")
%>
<h1>
처리결과:<%=request.getAttribute("result") %><br>
처리결과2:${result}
</h1>
</body>
</html>