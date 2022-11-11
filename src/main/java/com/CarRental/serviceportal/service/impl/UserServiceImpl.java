package com.CarRental.serviceportal.service.impl;

import com.CarRental.serviceportal.controller.bean.Car;
import com.CarRental.serviceportal.controller.bean.Rental;
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
    @Override
    public List<Car> getStatus(int rental,String start_time,String end_time,int seater,String car_model){
      //userDao.getStatus(rental);
        List<Car> car = userDao.getStatus(rental,start_time,end_time,seater,car_model);
        return  car;
    }
    public List<Rental> getToken(int rToken){
        List<Rental> rental = userDao.getToken(rToken);
        return rental;
    }

}
