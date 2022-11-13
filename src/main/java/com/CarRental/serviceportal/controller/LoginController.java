package com.CarRental.serviceportal.controller;

import com.CarRental.serviceportal.controller.bean.Car;
import com.CarRental.serviceportal.controller.bean.Rental;
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
    @RequestMapping(value="/order",method = RequestMethod.GET)
    public String order2Page(){
        return "order";
    }


    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String welcomePage(ModelMap model, @RequestParam String userId, @RequestParam String password){
        User user = userService.getUserByUserId(userId);

        if(user.getPassword().equals(password)){
            model.put("userId",userId);
            return "redirect:welcome";
        }
        model.put("errorMsg","userId or password is incorrect");
        return "login";
    }


    @RequestMapping(value="/welcome",method=RequestMethod.GET)
    public ModelAndView carPage(String model){
        ModelAndView model1 = new ModelAndView();

        List<Car> use = userService.getCars();
         Car c=new Car();
        use.add(c);
        model1.addObject("carService",use);
        return model1;
    }



    @RequestMapping(value="/book",method=RequestMethod.POST)
    public ModelAndView bookPage(String model,@RequestParam int rental,@RequestParam String start_time,@RequestParam String end_time,
                                 @RequestParam int seater,@RequestParam String car_model ){
        //model.put("rental",rental);
        ModelAndView mode = new ModelAndView();

        List<Car> use = userService.getStatus(rental,start_time,end_time,seater,car_model);
        Car c=new Car();
        use.add(c);
        mode.addObject("booking",use);
        mode.setViewName("book");
        return mode;
    }

    @RequestMapping(value="/historylogin",method = RequestMethod.GET)
    public String historyloginPage(){
        return "historylogin";
    }


    @RequestMapping(value="/historylogin",method=RequestMethod.POST)
    public ModelAndView historyPage(String model,@RequestParam int rToken ){
        ModelAndView mode1 = new ModelAndView();
        List<Rental> use = userService.getToken(rToken);
        Rental r = new Rental();
        use.add(r);
        mode1.addObject("historyPage",use);
        mode1.setViewName("history");
        return mode1;
    }

    @RequestMapping(value="/oder",method=RequestMethod.GET)
    public ModelAndView orderPage(String model){
        ModelAndView model1 = new ModelAndView();

        List<Car> use = userService.getOrder();
        Car c=new Car();
        use.add(c);
        model1.addObject("Service",use);
        model1.setViewName("order");
        return model1;
    }


}
