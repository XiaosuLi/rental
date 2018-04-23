<%--
  Created by IntelliJ IDEA.
  User: 小苏
  Date: 2018/4/17
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" import="java.util.*"%>
<html>
<head>
    <title>注册页面</title>

    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
    </script>
    <script>
        /*获取验证码的事件*/
        $(document).ready(function(){
            $("#mybutton").click(function(){
                var params = {};
                params.userPhone = $("#userPhone").val();

                $.ajax({
                    async:false,
                    type: "POST",
                    url: "http://localhost:8080/user/getcode",//注意路径
                    data:params,
                    dataType:"json",
                    success:function(data){
                        if(data.result=='SUCCESS'){
                            alert("短信验证码发送成功");
                        }else{
                            alert("修改失败，失败原因【" + data.result + "】");
                        }
                    },
                    error:function(data){
                        alert(data.result);
                    }
                });

            });
        });

        /*注册的验证*/
        $(document).ready(function(){
            $("#btnregister").click(function(){
                var params = {};
                params.userName = $("#userName").val();
                params.userPhone = $("#userPhone").val();
                params.userPassword = $("#userPassword").val();
                params.testCode = $("#testCode").val();

                $.ajax({
                    async:false,
                    type: "POST",
                    url: "http://localhost:8080/user/doregister",//注意路径
                    data:params,
                    dataType:"json",
                    success:function(data){
                        if(data.result=='SUCCESS'){
                            alert("注册成功");
                            $(window).attr('location','http://localhost:8080/user/login');

                        }else{
                            alert("修改失败，失败原因【" + data.result + "】");
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

<%--<form action="http://localhost:8080/user/doregister" method="post">--%>
    用户姓名:<br>
    <input type="text" name="userName" id="userName">
    <br>

    用户密码:<br>
    <input type="password" name="userPassword" id="userPassword">
    <br>

    用户手机号:<br>
    <input type="text" name="userPhone" id="userPhone">
    <br>

    验证码:<br>
    <input type="text" name="testCode" id="testCode">
    <br>

    <button id="btnregister" >注册</button>

    <br>

<%--</form>--%>
<button id="mybutton" value="获取验证码">获取验证码</button>
</body>
</html>
