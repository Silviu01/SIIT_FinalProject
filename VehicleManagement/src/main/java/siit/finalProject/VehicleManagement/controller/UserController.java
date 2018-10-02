package siit.finalProject.VehicleManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import siit.finalProject.VehicleManagement.HasRole;
import siit.finalProject.VehicleManagement.domain.User;
import siit.finalProject.VehicleManagement.dto.RegisterUserRequest;
import siit.finalProject.VehicleManagement.exceptionsHandler.AccessDeniedException;
import siit.finalProject.VehicleManagement.exceptionsHandler.InvalidRegisterDetails;
import siit.finalProject.VehicleManagement.service.SecurityService;
import siit.finalProject.VehicleManagement.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    private SecurityService securityService;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegister() {
        return "/register";
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public String getAllUsers(Model model, HttpServletRequest request) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        model.addAttribute("user", new User());
        model.addAttribute("currentUser", securityService.getCurrentUser());
        model.addAttribute("registerUserRequest", new RegisterUserRequest());
        return "getUsers";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createUser(RegisterUserRequest registerUserRequest, Model model) {

       try{
           User registerUser = userService.getUser(registerUserRequest);
               userService.createUser(registerUser);
        return "redirect:/login";
    }catch (InvalidRegisterDetails invalidRegisterDetails){
           model.addAttribute("error2", "Invalid register details. Please try again");
       }
       return "/register";
    }

    @RequestMapping(value = "/getUsers/{id}", method = RequestMethod.GET)
    public String getUserDetails(@PathVariable int id, Model model) {
        User registerUser = userService.getById(id);
        model.addAttribute("updateRegisterUserRequest", userService.getRegisterUserRequest(registerUser));
        model.addAttribute("userId", id);
        return "updateUserDetails";
    }

    @RequestMapping(value = "/getUsers/update/{id}", method = RequestMethod.POST)
    public String updateUserDetails(RegisterUserRequest registerUserRequest, @PathVariable int id) {
        User registerUser = userService.getUserDetails(registerUserRequest);
        userService.updateUser(registerUser, id);
        return "redirect:/vehicle";
    }

    @HasRole(role = "admin")
    @RequestMapping(method = RequestMethod.GET, value = "getUsers/removeUser/{id}")
    public String removeUser(Model model, @PathVariable(name = "id") int id) {
        userService.removeUser(id);
        model.addAttribute("users", userService.getAllUsers());
        return "getUsers";
    }
}

