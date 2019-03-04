<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%--这个主要是为了可以直接跳转，方便能够利用域名直接到主页--%>
<%--<% response.sendRedirect("/product/display/list.shtml"); %>  --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h2>欢迎来到我的运动中心商场</h2>
<form action="/test/springmvc.do" method="post">
    <input type="text" value="" name="name">
    <input type="text" value="2015-01-09 09:03:09" name="birthday">
    <input type="submit" value="提交">
</form>

<h2>这里是后台跳转</h2>

<form action="/admin/index.do" method="post">
    <input type="submit" value="后台跳转">
</form>

<h2>这里是前台跳转</h2>

<form action="/product/display/list.shtml" method="post">
    <input type="submit" value="前台跳转">
</form>
</body>
</html>
