<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTl (6) Fmt Tag : formatNumber</title>
</head>
<body>
<!-- 사용할 값들 설정 -->
<c:set var="number" value="123456.78" scope="page" />
<c:set var="currency" value="2300000" scope="page" />
<c:set var="pattern" value="123456.789" scope="page" />


<h4>1. 숫자 형식 출력</h4>
<pre>
number 형식 출력 : 자동으로 3자리 끊어 읽기 적용
<fmt:formatNumber value="${number}" type="number"/>
<fmt:formatNumber value="987654.321" type="number"/>

currency 형식 출력 : 3자리 끊어읽기, 통화코드, 통화심볼이 앞에 표기되는 형식

<fmt:formatNumber value="50000" type="currency"
				  currencyCode="EUR"/>

pattern 출력
<fmt:formatNumber value="${pattern}" pattern=".00"/>
<fmt:formatNumber value="987654.321" pattern=".00"/>
<fmt:formatNumber value="987654.321" pattern="000,00.00"/>

</pre>

<hr>


<!-- 오늘의 날짜를 생성 -->
<c:set var="today" value="<%=new Date() %>"/>
<h4>2. 날짜 형식 출력</h4>
<pre>
(1) 시간만 출력
<fmt:formatDate value="${today}" type="time"/>

(2) 날짜만 출력
<fmt:formatDate value="${today}" type="date"/>

(3) 시간, 날짜 출력
<fmt:formatDate value="${today}" type="both"/>

</pre>
</body>
</html>











