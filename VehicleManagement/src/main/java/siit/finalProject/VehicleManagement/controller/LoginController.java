package siit.finalProject.VehicleManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import siit.finalProject.VehicleManagement.domain.User;
import siit.finalProject.VehicleManagement.exceptionsHandler.InvalidCredentials;
import siit.finalProject.VehicleManagement.service.LoginService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayLogin() {
        return "login";
    }

    /**
     * @param username
     * @param password
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(String username, String password,
                          Model model, HttpServletRequest request) {

        try {
            User user = loginService.login(username, password);
            request.getSession().setAttribute("currentUser", user);
            return "redirect:/vehicle";
        } catch (InvalidCredentials invalidCredentials) {
            model.addAttribute("error1", "Invalid Credentials");
        }
        return "login";
    }

    /**
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String doLogout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "login";
    }
}

