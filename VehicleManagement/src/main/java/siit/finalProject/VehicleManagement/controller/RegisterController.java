package siit.finalProject.VehicleManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import siit.finalProject.VehicleManagement.domain.RegisterUser;
import siit.finalProject.VehicleManagement.dto.RegisterUserRequest;
import siit.finalProject.VehicleManagement.service.UserServiceImpl;

@Controller
public class RegisterController {

    @Autowired
    UserServiceImpl userService;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegister(){
        return "/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createUser(RegisterUserRequest registerUserRequest){
        RegisterUser registerUser = userService.getUser(registerUserRequest);
        userService.createUser(registerUser);
        return "redirect:/login";
    }

    @RequestMapping (value = "/updateUserDetails/{id}", method = RequestMethod.GET)
    public String getUserDetails (@PathVariable int id, Model model){
        RegisterUser registerUser = userService.getById(id);
        model.addAttribute("updateRegisterUserRequest", userService.getRegisterUserRequest(registerUser));
        model.addAttribute("userId", id);
        return "updateUserDetails";
    }

    @RequestMapping (value = "/updateUserDetails/{id}", method = RequestMethod.POST)
    public String updateUserDetails (RegisterUserRequest registerUserRequest, @PathVariable int id){
        RegisterUser registerUser = userService.getUser(registerUserRequest);
        userService.updateUser(registerUser, id);
        return "redirect:/vehicle";
    }

}

