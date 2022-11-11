<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>welcome</title>
</head>

<body>
    <h2>welcome to the car rentals portal ! ${userId} </h2>

  <table border="1">
          <tr style="font-size:21">
              <td>car model</td>
              <td>5 seater or 7 seater</td>
              <td>Rent price</td>
              <td>Rental_id</td>

          </tr>
          <c:forEach var="impl" items="${carService}">
              <tr style="font-size: 17">
                  <td>${impl.carModel} </td>
                  <td>${impl.carNumber} </td>
                  <td>${impl.rentPrice} </td>
                  <td>${impl.rentalId} </td>
              </tr>
              </c:forEach>
      </table>
      <h3>Please enter the below details of the car to book</h3>
      <form  method="post" action="book" >

              Start-time:<input type="datetime-local" name="start_time" class="form-control mt-3"
                          placeholder="start time"/><br>
                          <br>
              End-Time:<input type="datetime-local" name="end_time" class="form-control mt-3"
                          placeholder="end time"/><br>
                          <br>
              <input type="number" name="seater" class="form-control mt-3"
                                      placeholder="seater 5 or 7"/><br>
                          <br>
             <input type="text" name="car_model" class="form-control mt-3"
                                                  placeholder="model"/><br>
                           <br>
              <input type="number" name="rental" class="form-control mt-3"
              placeholder="Rental Id"/>

              <button class="btn btn-dark btn-block mt-3">BOOK</button>
          </form>
</body>
</html>