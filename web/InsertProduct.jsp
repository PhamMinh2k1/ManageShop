<%-- Document : InsertUpdate Created on : Dec 9, 2022, 11:00:31 AM Author : Admin --%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Add new product</title>
                <style>
                    .insert-product {
                        display: inline-block;
                        margin: 50px 0px 0px 625px;

                    }

                    .insert-form {
                        background-color: white;
                        padding: 20px;
                        border-radius: 20px;
                        border: 2px solid black;
                    }

                    .insert-form input {
                        font-size: 18px;
                    }
                </style>
            </head>

            <body>
                <header class="header">
                    <%@include file="Header.jsp" %>
                </header><br>
                <br>
                <div class="insert-product">
                    <form class="insert-form" action="loadProducts?go=addProduct&uid=${sessionScope.acc.uid}"
                        method="post">
                        <label for="pname">Product's Name:</label><br>
                        <input type="text" name="pname"><br>
                        <label for="price">Set price:</label><br>
                        <input type="text" name="price"><br>
                        <label for="infor">About it:</label><br>
                        <input type="text" name="infor"><br>
                        <label for="image">Image's url:</label><br>
                        <input type="text" name="image"><br>
                        <label for="cid">Choose type:</label><br>
                        <select name="cid" id="cid">
                            <c:forEach items="${listC}" var="c">
                                <option value="${c.cid}">${c.cname}</option>
                            </c:forEach>
                        </select><br>
                        <label for="quantity">Quantity:</label><br>
                        <input type="number" name="quantity"><br>
                        <label for="discount">Discount:</label><br>
                        <input type="text" name="discount"><br>
                        <br>
                        <input type="submit" name="" value="Add to shop">
                    </form>
                </div>
            </body>

            </html>