package siit.finalProject.VehicleManagement.service;

import siit.finalProject.VehicleManagement.domain.Vehicle;
import siit.finalProject.VehicleManagement.dto.CreateVehicleRequest;

import java.util.List;

public interface VehicleService {

    List<Vehicle> getAllVehicles();

    void createVehicle (Vehicle vehicle);

    void removeVehicle (long id);

    void updateVehicle (Vehicle vehicle, long id);

    Vehicle getById(long id);

    Vehicle getVehicle(CreateVehicleRequest vehicleRequest);

    CreateVehicleRequest getVehicleRequest(Vehicle vehicle);
}
