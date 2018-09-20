package siit.finalProject.VehicleManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import siit.finalProject.VehicleManagement.domain.User;
import siit.finalProject.VehicleManagement.dto.RegisterUserRequest;
import siit.finalProject.VehicleManagement.service.SecurityService;
import siit.finalProject.VehicleManagement.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    private SecurityService securityService;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegister(){
        return "/register";
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public String getAllUsers(Model model, HttpServletRequest request){
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        model.addAttribute("user", new User());
        model.addAttribute("currentUser", securityService.getCurrentUser());
        model.addAttribute("registerUserRequest", new RegisterUserRequest());
        return "getUsers";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createUser(RegisterUserRequest registerUserRequest){
        User registerUser = userService.getUser(registerUserRequest);
        userService.createUser(registerUser);
        return "redirect:/login";
    }
//
//    @RequestMapping (value = "/getUsers/{id}", method = RequestMethod.GET)
//    public int getCurrentId(){
//        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return user.getId();
//    }

    @RequestMapping (value = "/getUsers/{id}", method = RequestMethod.GET)
    public String getUserDetails (@PathVariable int id, Model model){
        User registerUser = userService.getById(id);
        model.addAttribute("updateRegisterUserRequest", userService.getRegisterUserRequest(registerUser));
        model.addAttribute("userId", id);
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("currentId", user.getId());
        return "updateUserDetails";
    }

    @RequestMapping (value = "/getUsers/update/{id}", method = RequestMethod.POST)
    public String updateUserDetails (RegisterUserRequest registerUserRequest, @PathVariable int id){
        User registerUser = userService.getUser(registerUserRequest);
        userService.updateUser(registerUser, id);
        return "redirect:/vehicle";
    }

}

