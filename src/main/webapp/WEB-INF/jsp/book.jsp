<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>booking page</title>
</head>
<body>
<h2>your car is booked</h2>
<h2>booking details</h2>
<table border="1">
          <tr style="font-size:21">
              <td>car model</td>
              <td>5 seater or 7 seater</td>
              <td>Rent price</td>
              <td>Registration Token</td>

          </tr>
          <c:forEach var="impl" items="${booking}">
              <tr style="font-size: 17">
                  <td>${impl.carModel} </td>
                  <td>${impl.carNumber} </td>
                  <td>${impl.rentPrice} </td>
                  <td>${impl.rentalId} </td>
              </tr>
              </c:forEach>
      </table>
      <br>
      <br>
      <br>
      <a href="/welcome"> Home</a><br>
      <a href="/historylogin"> history checker</a>
</body>


</html>