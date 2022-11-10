package com.CarRental.serviceportal.dao;

import com.CarRental.serviceportal.controller.bean.Car;
import com.CarRental.serviceportal.controller.bean.User;

import java.util.List;

public interface UserDao {
    User getUserById(String userId);
    List<Car> getCars(String model);

}
