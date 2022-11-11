package com.CarRental.serviceportal.controller.bean;

public class Rental {
    int rentalIde;
    String sDate;
    String eDate;
    String rModel;
    int rentalSeater;

    public String getrModel() {
        return rModel;
    }

    public void setrModel(String rModel) {
        this.rModel = rModel;
    }

    public int getRentalIde() {
        return rentalIde;
    }

    public void setRentalIde(int rentalIde) {
        this.rentalIde = rentalIde;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public String geteDate() {
        return eDate;
    }

    public void seteDate(String eDate) {
        this.eDate = eDate;
    }

    public int getRentalSeater() {
        return rentalSeater;
    }

    public void setRentalSeater(int rentalSeater) {
        this.rentalSeater = rentalSeater;
    }



}
