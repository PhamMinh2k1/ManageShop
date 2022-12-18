<%-- Document : SignUp Created on : Dec 13, 2022, 5:55:07 AM Author : Admin --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Sign In</title>
            <style>
                .signin-infor {
                    display: inline-block;
                    margin: 50px 0px 0px 625px;

                }

                .signin-form {
                    background-color: white;
                    padding: 20px;
                    border-radius: 20px;
                    border: 2px solid black;
                }

                .signin-form input,
                label {
                    font-size: 18px;
                }

                a {
                    text-decoration: none;
                    color: white;
                }

                a:hover {
                    color: red;
                }
            </style>
        </head>

        <body>
            <header class="header">
                <%@include file="Header.jsp" %>
            </header><br>
            <div class="signin-infor">
                <form class="signin-form" action="account?go=signIn" method="post">
                    <label for="username">Username:</label><br>
                    <input type="text" name="username" placeholder="Ex:user@123" value="${username}"><br><br>
                    <label for="password">Password:</label><br>
                    <input type="password" name="password" placeholder="******"><br><br>
                    <label for="password">Re-password:</label><br>
                    <input type="password" name="rePassword" placeholder="******"><br><br>
                    <label for="qid">Choose a question:</label><br>
                    <select name="qid" id="qid">
                        <c:forEach items="${listQ}" var="q">
                            <option value="${q.qid}">${q.infor}</option>
                        </c:forEach>
                    </select><br><br>
                    <label for="username">Your answer:</label><br>
                    <input type="password" name="answer" placeholder="Ex: Red"><br><br>
                    <input type="submit" value="Sign In"><br>
                    <h2 style="color: red;">${mess}</h2>
                </form>
            </div>

        </body>

        </html>