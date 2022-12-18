<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body {
            background-image: url("Images/WebCss/backgr1.jpg");
            background-repeat: no-repeat;
            background-size: cover;
        }

        .header {
            display: flex;
            justify-content: space-between;
            background-color: aqua;
            padding: 15px;
            border: 1px;
            border-radius: 10px;
        }

        .header-left {
            display: flex;
            justify-content: space-between;
        }

        .header-left div {
            padding: 5px 10px;
            font-size: 20px;
            border-left: 1px solid black;
        }

        .view-product a {
            text-decoration: none;
            font-size: 20px;
            font-family: monospace;
            text-align: center;
            color: black;
            padding: 5px;
        }

        .view-product a:hover {
            color: red;
            background-color: burlywood;
        }

        .logo a {
            text-decoration: none;
            font-size: 20px;
            font-family: monospace;
            text-align: center;
            color: black;
        }

        .logo a:hover {
            color: red;
            background-color: burlywood;
        }

        .search-box {
            font-size: 20px;
            padding: 5px;
            border-left: 1px solid black;
        }

        .login-signup {
            display: flex;
            justify-content: space-between;
        }

        .login-signup a {
            text-decoration: none;
            color: black;
            padding: 5px 10px;
            font-size: 20px;
        }

        .login-signup a:hover {
            color: red;
            background-color: burlywood;
        }

        .view-product {
            position: relative;
            display: inline-block;
        }

        .dropdown-categories {
            display: none;
            position: absolute;
            background-color: azure;
        }
        .dropdown-categories a{
            text-decoration: none;
            color: black;
            display: block;
            padding: 5px;
        }
        .view-product:hover .dropdown-categories{
            display: block;
        }
        .header-mid a{
            font-size: 20px;
            color: black;
            text-decoration: none;
            padding: 5px;
        }
        .header-mid a:hover{
            color: red;
            background-color: burlywood;
        }
        
    </style>
    
</head>

<div class="header-left">
    <div class="logo">
        <a href="home">Void Monody</a>
    </div>
    <div class="view-product">
        <a href="loadProducts?go=loadAll">View Product</a>
        <div class="dropdown-categories">
            <c:forEach items="${listC}" var="c">
                <a href="loadProducts?go=loadByCid&cid=${c.cid}">${c.cname}</a>
            </c:forEach>
        </div>
    </div>
    <form class="search-box" action="loadProducts?go=loadByName" method="post">
        <input type="search" placeholder="Search here..." name="name">
        <button type="submit"><i class="fa fa-search"></i></button>
    </form>
</div>
<div class="header-mid">
    <c:if test="${sessionScope.acc != null}">
        <a href="account?go=showUserInfor&uid=${sessionScope.user.uid}">Welcome back, ${sessionScope.user.name}</a>
    </c:if>
</div>
<div class="header-right">
    <div class="login-signup">
        <c:if test="${sessionScope.acc == null}">
            <a href="Login.jsp">Login</a>
            <a href="account?go=showSignIn">Sign In</a>
        </c:if>
        <c:if test="${sessionScope.acc != null}">
            <a href="account?go=logout">Log Out</a>
        </c:if>
    </div>
</div>