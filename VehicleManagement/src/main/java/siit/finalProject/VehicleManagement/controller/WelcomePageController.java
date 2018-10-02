package siit.finalProject.VehicleManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import siit.finalProject.VehicleManagement.domain.Vehicle;
import siit.finalProject.VehicleManagement.service.VehicleService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class WelcomePageController {


    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String vehicleTable(Model model, HttpServletRequest request) {
        List<Vehicle> vehicleList = vehicleService.getAllVehicles();
        model.addAttribute("cars", vehicleList);
        model.addAttribute("car", new Vehicle());
        return "welcomePage";
    }
}
