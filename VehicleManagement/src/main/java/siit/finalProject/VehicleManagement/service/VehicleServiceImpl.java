package siit.finalProject.VehicleManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.finalProject.VehicleManagement.dao.VehicleDao;
import siit.finalProject.VehicleManagement.domain.Vehicle;
import siit.finalProject.VehicleManagement.dto.CreateVehicleRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleDao vehicleDao;
    private List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleDao.getAllVehicles();
    }

    /**
     * @param vehicle
     */
    @Override
    public void createVehicle(Vehicle vehicle) {
        vehicleDao.createVehicle(vehicle);
    }

    /**
     * @param vehicle
     * @param id
     */
    @Override
    public void updateVehicle(Vehicle vehicle, long id) {
        vehicles = vehicles.stream().filter(vehicle1 -> vehicle1.getId() != id).collect(Collectors.toList());
        vehicle.setId(id);
        vehicles.add(vehicle);
        vehicleDao.updateVehicle(vehicle, id);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Vehicle getById(long id) {
        return vehicleDao.getById(id);
    }

    /**
     * @param id
     */
    @Override
    public void removeVehicle(long id) {
        vehicleDao.removeVehicle(id);
    }

    /**
     * @param vehicleRequest
     * @return
     */
    @Override
    public Vehicle getVehicle(CreateVehicleRequest vehicleRequest) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVmodel(vehicleRequest.getVmodel());
        vehicle.setVname(vehicleRequest.getVname());
        vehicle.setVyear(vehicleRequest.getVyear());
        vehicle.setVcolor(vehicleRequest.getVcolor());
        vehicle.setVcost(vehicleRequest.getVcost());
        vehicle.setVstatus(vehicleRequest.getVstatus());

        return vehicle;
    }

    /**
     * @param vehicle
     * @return
     */
    @Override
    public CreateVehicleRequest getVehicleRequest(Vehicle vehicle) {
        CreateVehicleRequest vehicleRequest = new CreateVehicleRequest();
        vehicleRequest.setVmodel(vehicle.getVmodel());
        vehicleRequest.setVname(vehicle.getVname());
        vehicleRequest.setVyear(vehicle.getVyear());
        vehicleRequest.setVcolor(vehicle.getVcolor());
        vehicleRequest.setVcost(vehicle.getVcost());

        return vehicleRequest;
    }
}
