<%-- Document : User Infor Created on : Dec 12, 2022, 7:49:03 AM Author : Admin --%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Update Infor</title>
                <style>
                    .update-infor{
                        display: inline-block;
                        margin:  50px 0px 0px 625px;

                    }
                    .update-form{
                        background-color: white;
                        padding: 20px;
                        border-radius: 20px;
                        border: 2px solid black;
                    }
                    .update-form input{
                        font-size: 18px;
                    }
                </style>
            </head>

            <body>
                <header class="header">
                    <%@include file="Header.jsp" %>
                </header><br>
                <div class="update-infor">
                    <form class="update-form" action="account?go=updateInfor&uid=${user.uid}" method="POST">
                        <label for="name">Name: </label><br>
                        <input type="text" name="name" value="${user.name}" >
                        <br><br>
                        <label for="dob">Birth Date: </label><br>
                        <input type="date" name="dob" value="${user.dob}">
                        <br><br>
                        <label for="gender">Gender: </label>
                        <input type="radio" name="gender" value="1" ${user.gender?"checked":""}>Male
                        <input type="radio" name="gender" value="0" ${user.gender?"":"checked"}>Female
                        <br><br>
                        <label for="address">Address: </label><br>
                        <input type="text" name="address" value="${user.address}">
                        <br><br>
                        <label for="phone">Phone number: </label><br>
                        <input type="text" name="phone" value="${user.phone}">
                        <br><br>
                        <label for="email">Email: </label><br>
                        <input type="text" name="email" value="${user.email}">
                        <br><br>
                        <input type="submit" value="Update">
                    </form>
                </div>

            </body>

            </html>