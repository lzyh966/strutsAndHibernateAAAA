<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%@ taglib prefix="s" uri="/struts-tags" %>  
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%= basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	欢迎你:
	<%-- <s:property value="#session['user'].trueName"/> --%>
	
	<s:set name="user" value="#session['user']" />
	
	<s:property value="#user.trueName"/>
	
	<s:debug></s:debug>
</body>
</html>