package com.CarRental.serviceportal.service.impl;


import com.CarRental.serviceportal.controller.bean.Car;
import com.CarRental.serviceportal.dao.SortingDao;
import com.CarRental.serviceportal.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortingServiceImpl implements SortingService {

    @Autowired
    SortingDao sortingDao;

    @Override
    public List<Car> getSorting(String sort){
        List<Car> car =sortingDao.getAfterSorting(sort);
       return car;

    }
}
