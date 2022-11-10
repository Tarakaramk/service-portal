package com.CarRental.serviceportal.dao.impl;

import com.CarRental.serviceportal.controller.bean.Car;
import com.CarRental.serviceportal.controller.bean.User;
import com.CarRental.serviceportal.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
    List<Car> lst = new ArrayList<Car>();
    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }
    @Override
    public User getUserById(String userId) {
        String sql= "select user_pswd from user where user_id=?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{ userId }, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUserId(userId);
                user.setPassword(rs.getString(1));
                return user;
            }
        });
    }
    @Override
    public List<Car> getCars(String model){
        String sql="select *from car";
        List<Map<String,Object>> lst=jdbcTemplate.queryForList(sql);
        List<Car> cr = new ArrayList<>() ;
        for(Map<String,Object> map:lst){
            Car cl = new Car();
            cl.setCarNumber((Integer)map.get("car_number"));
            cl.setCarModel((String)map.get("car_model"));
            cl.setRentPrice((Integer)map.get("rent_price"));
            cl.setRentalId((Integer)map.get("rental_id"));
            cr.add(cl);
            System.out.println(cl.getCarModel());
        }
       return cr;
    }
}
