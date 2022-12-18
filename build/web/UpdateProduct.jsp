<%-- Document : Update Created on : Dec 13, 2022, 7:43:26 AM Author : Admin --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Update Product</title>
            <style>
                .update-product-infor {
                    display: inline-block;
                    margin: 50px 0px 0px 625px;

                }

                .update-product-form {
                    background-color: white;
                    padding: 20px;
                    border-radius: 20px;
                    border: 2px solid black;
                }

                .update-product-form input {
                    font-size: 18px;
                }
            </style>
            <script>
                function messUpdate() {
                    alert("Update successfully.");
                }
            </script>
        </head>

        <body>
            <header class="header">
                <%@include file="Header.jsp" %>
            </header><br>
            <br>
            <div class="update-product-infor">
                <form class="update-product-form" action="loadProducts?go=updateProduct&uid=${p.pid}" method="post">
                    <label for="pname">Product's Name:</label><br>
                    <input type="text" name="pname" value="${p.pname}"><br>
                    <label for="price">Set price:</label><br>
                    <input type="text" name="price" value="${p.price}"><br>
                    <label for="infor">About it:</label><br>
                    <input type="text" name="infor" value="${p.infor}"><br>
                    <label for="image">Image's url:</label><br>
                    <input type="text" name="image" value="${p.image}"><br>
                    <label for="cid">Choose type:</label><br>
                    <select name="cid" id="cid">
                        <c:forEach items="${listC}" var="c">
                            <option value="${p.cid}">${c.cname}</option>
                        </c:forEach>
                    </select><br>
                    <label for="quantity">Quantity:</label><br>
                    <input type="number" name="quantity" value="${p.quantity}"><br>
                    <label for="discount">Discount:</label><br>
                    <input type="text" name="discount" value="${p.discount}"><br>
                    <br>
                    <input type="submit" name="" value="Update" onclick="messUpdate()">
                </form>
            </div>
        </body>

        </html>