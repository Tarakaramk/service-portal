<html>
<head>
    <title>welcome</title>
</head>

<body>
    <h2>welcome to the car rentals portal ! ${userId} </h2>

  <table border="1" method="post">
          <tr style="font-size: 13">
              <td>car model</td>
              <td>5 seater or 7 seater</td>
              <td>car price</td>
              <td>Rental id</td>
          </tr>
          <c:forEach var="impl" items="${carService}">
              <tr style="font-size: 10">
                  <td><input type="text" id="car_model" value=${impl.getCarModel()} ></td>
                  <td><input type="text" id="car_number" value=${impl.getCarNumber()} ></td>
                  <td><input type="text" id="rent_price" value=${impl.getRentPrice()} ></td>
                  <td><input type="text" id="rent_id" value=${impl.getRentalId()} ></td>

              </tr>
              </c:forEach>
      </table>
</body>
</html>