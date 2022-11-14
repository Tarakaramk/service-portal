package com.CarRental.serviceportal.controller.bean;

import java.util.Comparator;

public class Car {
    int carNumber;
    String carModel;
    int rentPrice;
    int rentalId;

    int rental;

    public int getRental() {
        return rental;
    }

    public void setRental(int rental) {
        this.rental = rental;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public class sortbyPrice implements Comparator<Car>
    {
        public int compare(Car a, Car b)
        {
            return a.rentPrice - b.rentPrice;
        }
    }

    public class sortbyPriceDesc implements Comparator<Car>
    {
        public int compare(Car a, Car b)
        {
            return a.rentPrice - b.rentPrice;
        }
    }

}
