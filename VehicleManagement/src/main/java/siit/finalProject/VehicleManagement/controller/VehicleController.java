package siit.finalProject.VehicleManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import siit.finalProject.VehicleManagement.HasRole;
import siit.finalProject.VehicleManagement.domain.Vehicle;
import siit.finalProject.VehicleManagement.dto.CreateVehicleRequest;
import siit.finalProject.VehicleManagement.service.SecurityService;
import siit.finalProject.VehicleManagement.service.VehicleService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class VehicleController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private VehicleService vehicleService;

    /**
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/vehicle")
    public String listVehicles(Model model, HttpServletRequest request) {
        List<Vehicle> vehicleList = vehicleService.getAllVehicles();
        model.addAttribute("cars", vehicleList);
        model.addAttribute("car", new Vehicle());
        model.addAttribute("user", securityService.getCurrentUser());
        model.addAttribute("createVehicleRequest", new CreateVehicleRequest());
        return "vehicle";
    }

    /**
     * @param vehicleRequest
     * @return
     */

    @RequestMapping(method = RequestMethod.POST, value = "/vehicle")
    public String createVehicle(@Valid CreateVehicleRequest vehicleRequest) {
        Vehicle vehicle = vehicleService.getVehicle(vehicleRequest);
        vehicleService.createVehicle(vehicle);
        return "redirect:/vehicle";
    }

    @HasRole(role = "admin") @HasRole(role = "dealer")
    @RequestMapping(method = RequestMethod.GET, value = "/vehicle/{id}")
    public String getVehicle(@PathVariable long id, Model model) {
        Vehicle vehicle = vehicleService.getById(id);
        model.addAttribute("updateVehicleRequest", vehicleService.getVehicleRequest(vehicle));
        model.addAttribute("vehicleId", id);
        return "updateVehicle";
    }

    /**
     * @param vehicleRequest
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/vehicle/update/{id}")
    public String updateVehicle(CreateVehicleRequest vehicleRequest, @PathVariable long id) {
        Vehicle vehicle = vehicleService.getVehicle(vehicleRequest);
        vehicleService.updateVehicle(vehicle, id);
        return "redirect:/vehicle";
    }

    /**
     * @param model
     * @param id
     * @return
     */
    @HasRole(role = "admin") @HasRole(role = "dealer")
    @RequestMapping(method = RequestMethod.GET, value = "vehicle/removeVehicle/{id}")
    public String removeVehicle(Model model, @PathVariable(name = "id") int id){
        vehicleService.removeVehicle(id);
        model.addAttribute("message1", "Car deleted");
        model.addAttribute("cars", vehicleService.getAllVehicles());

        return "redirect:/vehicle";
        //TODO restrict acces for customer on DELETE button and createVehicle/addNewCar
    }
}
