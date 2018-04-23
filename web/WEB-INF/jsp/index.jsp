<%--
  Created by IntelliJ IDEA.
  User: 小苏
  Date: 2018/4/23
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@
 page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
 isELIgnored="false"
 import="java.util.*"  import="com.rental.pojo.*"
%>
<%--1、编码设置 2、开启EL表达式 3、导入包--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
    <title>首页</title>
</head>
<body>
<h2>这是主页</h2>

<%--获取对象里的属性，从Controller里传递过来的--%>



<c:if test="${empty user}">
    <h2>用户未登录</h2>
    <a href="http://localhost:8080/user/login">登录</a>
    <a href="http://localhost:8080/user/register">注册</a>
</c:if>
<br>

<c:if test="${!empty user}">
    <h2>用户登录</h2>
    ${user.userName}
</c:if>

</body>
</html>
