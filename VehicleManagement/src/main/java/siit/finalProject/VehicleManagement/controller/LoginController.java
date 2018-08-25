package siit.finalProject.VehicleManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import siit.finalProject.VehicleManagement.domain.User;
import siit.finalProject.VehicleManagement.service.LoginService;

import java.util.List;


public class LoginController {
//
//
//        @RequestMapping(value = "/index.html", method = RequestMethod.GET)
//        public String init(Model model) {
//
//            model.addAttribute("index.html", "Please Enter Your Login Details");
//            return "index";
//        }
//
//        @RequestMapping(value = "/index.html", method = RequestMethod.POST)
//        public String submit(Model model, User user) {
//
//            if (user != null && user.getUsername() != null & user.getPassword() != null) {
//                if (user.getUsername().equals("chandra") && user.getPassword().equals("chandra123")) {
//                    model.addAttribute("msg", user.getUsername());
//                    return "redirect:/vehicle.html";
//                } else {
//                    model.addAttribute("error", "Invalid Details");
//                    return "error";
//                }
//            } else {
//                model.addAttribute("error", "Please enter Details");
//                return "error";
//            }
//        }

    }

