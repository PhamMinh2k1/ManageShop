<%-- Document : Login Created on : Dec 9, 2022, 8:07:28 AM Author : Admin --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Login</title>
            <style>
                a {
                    text-decoration: none;
                    color: white;
                }

                a:hover {
                    color: red;
                }

                h2 {
                    color: white;
                }

                .login-infor {
                    display: inline-block;
                    margin: 50px 0px 0px 625px;

                }

                .login-form {
                    background-color: white;
                    padding: 20px;
                    border-radius: 20px;
                    border: 2px solid black;
                }

                .login-form input ,label{
                    font-size: 18px;
                }
            </style>
            <script>

            </script>
        </head>

        <body>
            <header class="header">
                <%@include file="Header.jsp" %>
            </header><br>
            <div class="login-infor">
                <form class="login-form" action="account?go=login" method="post">
                    <label for="username">Username:</label><br>
                    <input type="text" name="username" placeholder="user1234"><br><br>
                    <label for="password">Password:</label><br>
                    <input type="password" name="password" placeholder="********">
                    <br><br>
                    <input type="submit" value="Login"><br>
                    <h2 style="color: red;">${mess}</h2>
                </form>
                <h2><a href="account?go=toChangePass">Forgot password?</a></h2>
                <h2>Not have account? <a href="account?go=showSignIn">Click here</a></h2>
                <h2><a href="home">Back to home</a></h2>
            </div>

        </body>

        </html>