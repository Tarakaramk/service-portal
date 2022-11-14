package com.CarRental.serviceportal.service;

import com.CarRental.serviceportal.controller.bean.Car;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public interface SortingService {
    List<Car> getSorting(String sort);
}
