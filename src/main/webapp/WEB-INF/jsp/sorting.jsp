<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Person List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>

  <style>
  table, th, td {
    border: 1px solid black;
  }
  table.center {
    margin-left: auto;
    margin-right: auto;
  }
  </style>
  </head>
  <body>
    <h1>sort</h1>

    <br/><br/>
    <div>

          <form  method="post">
          <input type="text" name="sort" id="sort" placeholder="asc|desc" >
          <br>
          <input type="submit" value="show">
         </form>

    </div>
  </body>

</html>