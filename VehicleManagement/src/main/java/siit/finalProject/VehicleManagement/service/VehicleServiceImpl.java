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

    @Override
    public void createVehicle(Vehicle vehicle) {
        vehicleDao.createVehicle(vehicle);
    }

    @Override
    public void removeVehicle(int id) {
        int indexToRemove = -1;

        for (int i = 0; i < vehicles.size(); i++)
            if (vehicles.get(i).getId() == id) {
                indexToRemove = 0;
            }
        if (indexToRemove >= 0) {
            vehicles.remove(indexToRemove);
        }
    }

    @Override
    public void updateVehicle(Vehicle vehicle, int id) {
        vehicles = vehicles.stream().filter(vehicle1 -> vehicle1.getId() != id).collect(Collectors.toList());
        vehicle.setId(id);
        vehicles.add(vehicle);
        vehicleDao.updateVehicle(vehicle, id);
    }

    @Override
    public Vehicle getById(int id) {
        return vehicleDao.getById(id);
    }

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