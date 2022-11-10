<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <title>login page</title>
    <link href="webjars/bootstrap/4.6.0/css/bootstrap.min.css"
     rel="stylesheet">
    <style>
    .login-form{
     width: 400px;
     height: 200px;
     position: absolute;
     background-color:#45B8AC;
     border-radius: 5%;
     top:50%;
     left:50%;
     margin-right:-50%;
     transform:translate(-50%,-50%)
    }
    </style>
</head>
<body>
    <div class="login-form">

    <c:if test="${not empty errorMsg}">
    <div class ="alert alert-danger" role="alert">${errorMsg}</div>
    </c:if>

    <div class="container-fluid">
    <form method="post">
        <input type="text" name="userId" class="form-control mt-3"
        placeholder="User ID"/>

        <input type="password" name="password" class="form-control mt-3"
        placeholder="Password"/>

        <button class="btn btn-dark btn-block mt-3">login</button>
    </form>
    </div>
    </div>
    </body>

    </html>