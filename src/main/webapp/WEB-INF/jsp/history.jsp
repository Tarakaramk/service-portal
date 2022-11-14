<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>history page</title>
</head>
<body>
<h2>previous history</h2>
<table border="1">
          <tr style="font-size:21">
              <td>car model</td>
              <td>5 seater or 7 seater</td>
              <td>Registration Token</td>
              <td>Rent start date</td>
              <td>Rent end date</td>

          </tr>
          <c:forEach var="impl" items="${historyPage}">
              <tr style="font-size: 17">
                  <td>${impl.rModel} </td>
                  <td>${impl.rentalSeater} </td>
                  <td>${impl.rentalIde} </td>
                  <td>${impl.sDate} </td>
                  <td>${impl.eDate} </td>
              </tr>
              </c:forEach>
      </table>
      <br>
      <a href="/welcome"> Home</a><br>
</body>


</html>