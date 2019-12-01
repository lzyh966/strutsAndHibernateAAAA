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
	<title>User Regist</title>
	
	<link rel="stylesheet" type="text/css" href="css/base.css">
	
	<style type="text/css">
		.regist {
			width: 500px;
			height: 400px;
			border: solid 1px #f0f;
			margin: 100px auto auto auto;
		}
		
		.submitBtn {
			width: 200px;
			line-height: 40px;
			margin: 10px auto auto auto;
		}
	</style>
</head>
<body>
	<div class="wrapper">
		<div class="regist">
			<!-- enctype="multipart/form-data" 表示编码方式以二进制流的方式来处理表单数据,把文件域中指定文件的内容封装到请求参数中 -->
			<s:form action="regist" theme="simple" enctype="multipart/form-data">
				<h2>用户注册</h2>
				<fieldset>
					<legend>用户信息</legend>
					
					<s:fielderror></s:fielderror>
					
					<table>
						<tr>
							<td>用户名</td>
							<td>
								<s:textfield name="user.userName"></s:textfield>
							</td>
						</tr>
						
						<tr>
							<td>真实名</td>
							<td>
								<s:textfield name="user.trueName"></s:textfield>
							</td>
						</tr>
						
						<tr>
							<td>密码</td>
							<td>
								<s:password name="user.password"></s:password>
							</td>
						</tr>
						
						<tr>
							<td>照片</td>
							<td>
								<s:file name="photo"></s:file>
							</td>
						</tr>
					</table>
				</fieldset>
				
				<s:submit value="提交" cssClass="submitBtn"></s:submit>
			</s:form>
		</div>
	</div>	<!-- end of wrapper -->
</body>
</html>