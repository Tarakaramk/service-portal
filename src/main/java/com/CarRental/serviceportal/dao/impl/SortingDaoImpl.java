package com.CarRental.serviceportal.dao.impl;


import com.CarRental.serviceportal.controller.bean.Car;
import com.CarRental.serviceportal.dao.SortingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class SortingDaoImpl extends JdbcDaoSupport implements SortingDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public SortingDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Autowired
    UserDaoImpl userDaoImpl;

    @Override
    public List<Car> getAfterSorting(String sort){
        String s = "desc";

        List<Car> list=new ArrayList<>();
        list=userDaoImpl.returnList();
        Car a=new Car();
        Car.sortbyPrice b=a.new sortbyPrice();
        Car.sortbyPriceDesc c=a.new sortbyPriceDesc();

        if(s.equals(sort)){
            Collections.sort(list, c);

        }
        else {
            Collections.sort(list, b);
        }
       System.out.println("a");
        System.out.println("in global"+list);
        return list;
    }
}
