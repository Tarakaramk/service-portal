package com.CarRental.serviceportal.controller;

import com.CarRental.serviceportal.controller.bean.Car;
import com.CarRental.serviceportal.controller.bean.User;
import com.CarRental.serviceportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String welcomePage(ModelMap model, @RequestParam String userId, @RequestParam String password){
        User user = userService.getUserByUserId(userId);

        if(user.getPassword().equals(password)){
            model.put("userId",userId);
            return "welcome";
        }
        model.put("errorMsg","userId or password is incorrect");
        return "login";
    }

    @RequestMapping(value="/welcome",method=RequestMethod.POST)
    public ModelAndView carPage(String model){
        ModelAndView model1 = new ModelAndView();

        List<Car> use = userService.getCars(model);

        model1.addObject("carService",use);
        model1.addObject("welcome");
        return model1;
    }

}
