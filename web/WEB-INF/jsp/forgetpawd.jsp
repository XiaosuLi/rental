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
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
    </script>
<script>
    /*获取验证码的事件*/
    $(document).ready(function(){
        $("#btnGetCode").click(function(){
            var params = {};
            params.userPhone = $("#userPhone").val();

            $.ajax({
                async:false,
                type: "POST",
                url: "http://localhost:8080/user/getpawdcode",//注意路径
                data:params,
                dataType:"json",
                success:function(data){
                    if(data.result=='SUCCESS'){
                        alert("短信验证码发送成功");
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


    /*获取验证码的事件*/
    $(document).ready(function(){
        $("#btnChangePawd").click(function(){
            var params = {};
            params.userPhone = $("#userPhone").val();
            params.testCode = $("#testCode").val();

            $.ajax({
                async:false,
                type: "POST",
                url: "http://localhost:8080/user/changepawdcode",//注意路径
                data:params,
                dataType:"json",
                success:function(data){
                    if(data.result=='SUCCESS'){
                        alert("验证通过");
                        $(window).attr('location','http://localhost:8080/user/changepawd');
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

<h5>手机号</h5>
<input type="text" id="userPhone" name="userPhone">
<br>
<br>
<h5>验证码</h5>
<input type="text" id="testCode" name="testCode">
<br>

<button id="btnGetCode">获取验证码</button>
<button id="btnChangePawd">修改密码</button>




</body>
</html>
