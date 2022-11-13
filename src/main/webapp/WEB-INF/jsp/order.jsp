<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>price low-high</title>
</head>

<body>


  <table border="1">
          <tr style="font-size:21">
              <td>car model</td>
              <td>5 seater or 7 seater</td>
              <td>Rent price</td>
              <td>Rental_id</td>

          </tr>
          <c:forEach var="impl" items="${Service}">
              <tr style="font-size: 17">
                  <td>${impl.carModel} </td>
                  <td>${impl.carNumber} </td>
                  <td>${impl.rentPrice} </td>
                  <td>${impl.rentalId} </td>

              </tr>
              </c:forEach>
      </table>