package com.CarRental.serviceportal.service;

import com.CarRental.serviceportal.controller.bean.Car;
import com.CarRental.serviceportal.controller.bean.Rental;
import com.CarRental.serviceportal.controller.bean.User;

import java.util.List;

public interface UserService {
    User getUserByUserId(String userId);
    List<Car> getCars();

    List<Car> getStatus(int rental,String start_time,String end_time,int seater,String car_model);

    List<Rental> getToken(int rToken);

}
