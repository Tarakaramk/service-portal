package com.CarRental.serviceportal.service;

import com.CarRental.serviceportal.controller.bean.Car;
import com.CarRental.serviceportal.controller.bean.User;

import java.util.List;

public interface UserService {
    User getUserByUserId(String userId);
    List<Car> getCars();

}
