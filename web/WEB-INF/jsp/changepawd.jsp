<%--
  Created by IntelliJ IDEA.
  User: 小苏
  Date: 2018/4/23
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@
  page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  isELIgnored="false"
  import="java.util.*"
%>
<html>
<head>
    <title>忘记密码</title>
   <%-- /getpawdcode--%>



</head>
<body>

<form name="changepawd" action="http://localhost:8080/user/tochangepawd">
    <h5>密码</h5>
    <input type="text" id="userPassword" name="userPassword">
    <br>

    <input type="submit" value="确认修改">
</form>







</body>
</html>
