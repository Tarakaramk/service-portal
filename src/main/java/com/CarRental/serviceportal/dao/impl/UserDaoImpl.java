package com.CarRental.serviceportal.dao.impl;

import com.CarRental.serviceportal.controller.bean.Car;
import com.CarRental.serviceportal.controller.bean.Rental;
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
import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
    List<Car> lst = new ArrayList<Car>();
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }


    //login page validation(checking password)
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



    //displaying available cars to the user by getting data from database
    @Override
    public List<Car> getCars() {
        String sql = "select *from car where car_status=1";
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
        //System.out.println(lst);
        return lst;
    }



   // Three type functioning happens
    //updating available cars to the database by setting  status to 0 using sql
    //displaying booking details using sql1
    //inserting booking details to rentals table as history using sql2
    @Transactional
    public List<Car> getStatus(int rental,String start_time,String end_time,int seater,String car_model){

        LocalDate dateBefore = LocalDate.parse(start_time);
        LocalDate dateAfter = LocalDate.parse(end_time);

        // Approach 1
        long daysDiff = ChronoUnit.DAYS.between(dateBefore, dateAfter);
        int difference =(int)daysDiff;


        String sql ="update car set car_status=0 where rental_id=?";
        jdbcTemplate.update(sql,rental);


        String sql1 = "select *from car where rental_id=?";
        List<Car> stat = new ArrayList<>();


        String sql2="insert into rentals(rental_id,sdate,edate,model,seater)  values (?,?,?,?,?)";
        jdbcTemplate.update(sql2,new Object[]{rental,start_time,end_time,car_model,seater});


        stat = getJdbcTemplate().query(sql1, new Object[]{rental}, new ResultSetExtractor<List<Car>>() {
            @Override
            public List<Car> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Car> stat = new ArrayList<>();
                while (rs.next()) {
                    Car cr = new Car();
                    cr.setCarModel(rs.getString("car_model"));
                    cr.setCarNumber(rs.getInt("car_number"));
                    cr.setRentPrice(difference*(rs.getInt("rent_price")));
                    cr.setRentalId(rs.getInt("rental_id"));
                    stat.add(cr);
                }
                return stat;
            }
        });
        //System.out.println(lst);
        return stat;
    }


    //retrieving history details from rentals table and displaying to user
    public List<Rental> getToken(int rToken){
        String sql = "select *from rentals where rental_id=?";
        List<Rental> token = new ArrayList<>();
        token = getJdbcTemplate().query(sql, new Object[]{rToken}, new ResultSetExtractor<List<Rental>>() {
            @Override
            public List<Rental> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Rental> token = new ArrayList<>();
                while (rs.next()) {
                    Rental ren = new Rental();
                    ren.setRentalIde(rs.getInt("rental_id"));
                    ren.setsDate(rs.getString("sdate"));
                    ren.seteDate(rs.getString("edate"));
                    ren.setrModel(rs.getString("model"));
                    ren.setRentalSeater(rs.getInt("seater"));
                    token.add(ren);
                }
                return token;
            }
        });
        return token;
    }

    public List<Car> returnList(){
        return this.lst;
    }

}
