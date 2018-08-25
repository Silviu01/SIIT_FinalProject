package siit.finalProject.VehicleManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import siit.finalProject.VehicleManagement.domain.Vehicle;
import siit.finalProject.VehicleManagement.service.VehicleService;
import siit.finalProject.VehicleManagement.service.VehicleServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(method = RequestMethod.GET, value = "/vehicle")
    public String listVehicles(Model model, HttpServletRequest request) {

        List<Vehicle> vehicleList = vehicleService.getAllVehicles();

        model.addAttribute("cars", vehicleList);
        model.addAttribute("car", new Vehicle());

        return "vehicle";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/vehicle/delete/{id}")
    public String removeVehicle(@PathVariable int id, Model model) {
        vehicleService.removeVehicle(id);
        return "redirect:/vehicle";
    }
}
