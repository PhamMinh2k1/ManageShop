<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <style>
            @keyframes body {
            10% {
                background-image: url("Images/WebCss/backgr1.jpg");
            }

            30% {
                background-image: url("Images/WebCss/backgr2.jpg");
            }

            55% {
                background-image: url("Images/WebCss/backgr3.jpg");
            }

            75% {
                background-image: url("Images/WebCss/backgr4.jpg");
            }
            100% {
                background-image: url("Images/WebCss/backgr5.jpg");
            }
        }

        body {
            background-repeat: no-repeat;
            background-size: cover;
            animation-name: body;
            animation-duration: 10s;
            animation-delay: 0s;
            animation-iteration-count: infinite;
        }
        </style>
    </head>
    <body>
        <header class="header">
            <%@include file="Header.jsp"%>
        </header>
    </body>

</html>