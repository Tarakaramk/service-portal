package com.CarRental.serviceportal.dao.impl;

import com.CarRental.serviceportal.controller.bean.Car;
import com.CarRental.serviceportal.controller.bean.User;
import com.CarRental.serviceportal.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public User getUserById(String userId) {
        String sql = "select user_pswd from user where user_id=?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{userId}, new RowMapper<User>() {
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
    public List<Car> getCars() {
        String sql = "select *from car";
        List<Car> lst = new ArrayList<>();
        lst = getJdbcTemplate().query(sql, new Object[]{}, new ResultSetExtractor<List<Car>>() {
            @Override
            public List<Car> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Car> lst = new ArrayList<>();
                while (rs.next()) {
                    Car cl = new Car();
                    cl.setCarModel(rs.getString("car_model"));
                    cl.setCarNumber(rs.getInt("car_number"));
                    cl.setRentPrice(rs.getInt("rent_price"));
                    cl.setRentalId(rs.getInt("rental_id"));
                    lst.add(cl);
                }
                return lst;
            }
        });
        System.out.println(lst);
        return lst;
    }
}
