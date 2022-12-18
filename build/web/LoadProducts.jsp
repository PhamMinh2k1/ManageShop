<%-- 
    Document   : LoadProducts
    Created on : Dec 7, 2022, 4:41:20 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Products</title>
        <style>
            table,td,th{
                background-color: darkkhaki;
                border: 2px solid black;
                text-justify: distribute;
                text-align: center;
                color: black;
            }
            td a{
                text-decoration: none;
                color: black;
            }
            td a:hover{
                color: red;
            }
            .search-price label{
                color: white;
            }
            .action-out-table{
                display: flex;
                justify-content: space-between;
            }
        </style>
        <script>
            function showMessage(){
                var option = confirm("Are you sure to delete?");
                if(option === true){
                    alert("Delete Success.");
                }
            }
        </script>
    </head>
    <body>
        <header class="header">
            <%@include file="Header.jsp"%>
        </header><br>
        <div class="action-out-table">
            <form class="search-price" action="loadProducts?go=loadByPrice" method="post">
                <label for="priceFrom">From:</label>
                <input type="number" name="priceFrom" placeholder="0.0">
                <label for="priceTo">To:</label>
                <input type="number" name="priceTo" placeholder="0.0">
                <input type="submit" name="" value="Filter">
            </form>
                <a href="#">
                    <input type="button" value="View my cart" style="font-size: 18px;">
                </a>
        </div>

        <br>

        <table class="list-products">
            <thead>
                <tr>
                    <th>Product's Name</th>
                    <th>View</th>
                    <th>In Stock</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th colspan="3">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="p">
                    <tr>
                        <td>${p.pname}</td>
                        <td><img src="${p.image}" height="150px" width="100px"/></td>
                        <td>${p.quantity}</td>
                        <td>${p.infor}</td>
                        <td>${p.price}</td>
                        <td><a href="#">Buy</a></td>
                        <c:if test="${(sessionScope.acc.isAdmin == true) 
                                      || (sessionScope.acc.isSell == true && sessionScope.acc.uid == p.uid)}">
                            <td><a href="loadProducts?go=showEdit&pid=${p.pid}">Edit</a></td>
                            <td><a href="loadProducts?go=deleteProduct&pid=${p.pid}" onclick="showMessage()">Delete</a></td>
                        </c:if>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

    </body>
</html>
