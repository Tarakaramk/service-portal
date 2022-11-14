package com.CarRental.serviceportal.dao;

import com.CarRental.serviceportal.controller.bean.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SortingDao {
     List<Car> getAfterSorting(String sort);

}
