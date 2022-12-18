<%-- 
    Document   : ChangePassword
    Created on : Dec 13, 2022, 10:07:06 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change password</title>
        <style>
            form{
                color: white;
            }
            a{
                text-decoration: none;
                color: white;
            }
            a:hover{
                color: red;
            }
            h2{
                color: white;
            }
        </style>
    </head>
    <body>
        <header class="header">
            <%@include file="Header.jsp"%>
        </header><br>
        <form class="change-form" action="account?go=checkAccount" method="post">
            <label for="username">Username:</label><br>
            <input type="text" name="username" placeholder="Username" value="${username}"><br>
            <label for="qid">Choose:</label><br>
            <select name="qid" id="qid">
                <c:forEach items="${listQ}" var="q">
                    <option value="${q.qid}">${q.infor}</option>
                </c:forEach>
            </select><br>
            <label for="answer">Secret:</label><br>
            <input type="password" name="answer" placeholder="*******"><br><br>
            <input type="submit" value="Send"><br>
            <h2 style="color: red;">${mess}</h2>
        </form>
        <form action="account?go=changePass" method="post" ${status}>
            <label for="password">Password:</label><br>
            <input type="password" name="password" placeholder="********"><br>
            <label for="rePassword">Re-password:</label><br>
            <input type="password" name="rePassword" placeholder="********"><br><br>
            <input type="submit" value="Send"><br>
            <h2 style="color: red;">${mess2}</h2>
        </form>
    </body>
</html>
