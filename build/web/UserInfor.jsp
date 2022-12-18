<%-- Document : UserInfor Created on : Dec 13, 2022, 2:19:15 PM Author : Admin --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>About ${user.name}</title>
            <style>
                table,
                td,
                th {
                    background-color: darkkhaki;
                    border: 2px solid black;
                    text-justify: distribute;
                    text-align: center;
                    color: black;
                }

                td a {
                    text-decoration: none;
                    color: black;
                }

                td a:hover {
                    color: red;
                }

                .user-infor-2 {
                    background-color: white;
                    display: inline-block;
                    padding: 0px 10px;
                    border-radius: 8px;
                    border: 1px solid black;
                }
                .all-infor{
                    display: flex;
                    justify-content: space-around;
                }
                .user-infor-2 p {
                    font-size: 25px;
                }
                .btn{
                    font-size: 20px;
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
                <%@include file="Header.jsp" %>
            </header><br>
            <div class="all-infor">
                <div class="user-infor">
                    <a href="UpdateInfor.jsp">
                        <input class="btn" type="button" value="Update profile">
                    </a><br><br>
                    <div class="user-infor-2">
                        <p>Name: ${user.name}
                            <hr>
                        </p>
                        <p>Date of birth: ${user.dob}
                            <hr>
                        </p>
                        <p>Gender: ${user.gender?"Male":"Female"}
                            <hr>
                        </p>
                        <p>Address: ${user.address}
                            <hr>
                        </p>
                        <p>Phone: ${user.phone}
                            <hr>
                        </p>
                        <p>Email: ${user.email}
                            <hr>
                        </p>
                    </div>
                </div><br>

                <div class="user-product">
                    <c:if test="${sessionScope.acc.isAdmin == true || sessionScope.acc.isSell == true}">
                        <a href="loadCategories?go=addProduct">
                            <input class="btn" type="button" value="Add a new product">
                        </a><br>
                        <br>
                        <table class="list-products" style="width: 400px;">
                            <thead>
                                <tr>
                                    <th>Product's Name</th>
                                    <th>View</th>
                                    <th>In Stock</th>
                                    <th>Description</th>
                                    <th>Price</th>
                                    <th colspan="2">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listP}" var="p">
                                    <tr>
                                        <td>${p.pname}</td>
                                        <td><img src="${p.image}" height="150px" width="100px" /></td>
                                        <td>${p.quantity}</td>
                                        <td>${p.infor}</td>
                                        <td>${p.price}</td>
                                        <c:if test="${(sessionScope.acc.isAdmin == true) 
                                            || (sessionScope.acc.isSell == true && sessionScope.acc.uid == p.uid)}">
                                            <td><a href="loadProducts?go=showEdit&pid=${p.pid}">Edit</a></td>
                                            <td><a href="loadProducts?go=deleteProduct&pid=${p.pid}"
                                                    onclick="showMessage()">Delete</a></td>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>
            </div>
        </body>

        </html>