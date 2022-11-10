package com.CarRental.serviceportal.service.impl;

import com.CarRental.serviceportal.controller.bean.Car;
import com.CarRental.serviceportal.controller.bean.User;
import com.CarRental.serviceportal.dao.UserDao;
import com.CarRental.serviceportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User getUserByUserId(String userId){
        User user = userDao.getUserById(userId);
        return user;
    }
    @Override
    public List<Car> getCars(){
     List<Car> car = userDao.getCars();
     return  car;
    }

}
