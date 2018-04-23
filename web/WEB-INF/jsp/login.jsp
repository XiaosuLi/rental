<%--
  Created by IntelliJ IDEA.
  User: 小苏
  Date: 2018/4/17
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" import="java.util.*"%>
<html>
<head>
    <title>登录界面</title>

    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
    </script>
    <script>
        /*获取验证码的事件*/
        $(document).ready(function(){
            $("#btnlogin").click(function(){
                var params = {};
                params.userPhone = $("#userPhone").val();
                params.userPassword = $("#userPassword").val();

                $.ajax({
                    async:false,
                    type: "POST",
                    url: "http://localhost:8080/user/dologin",//注意路径
                    data:params,
                    dataType:"json",
                    success:function(data){
                        if(data.result=='SUCCESS'){
                            alert("登录成功");
                            $(window).attr('location','http://localhost:8080/index');
                        }else{
                            alert("【" + data.result + "】");
                        }
                    },
                    error:function(data){
                        alert(data.result);
                    }
                });

            });
        });
    </script>

</head>
<body>
    用户手机号:<br>
    <input type="text" name="userPhone" id="userPhone">
    <br>
    用户密码:<br>
    <input type="password" name="userPassword" id="userPassword">
    <br>
    <button id="btnlogin">登录</button>

    <a href="http://localhost:8080/user/forgetpawd">修改密码</a>

    <br>
    <br>
</form>
</body>
</html>
