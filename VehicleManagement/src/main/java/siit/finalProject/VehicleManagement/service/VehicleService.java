package siit.finalProject.VehicleManagement.service;

import ch.qos.logback.core.net.server.Client;
import siit.finalProject.VehicleManagement.domain.Vehicle;
import siit.finalProject.VehicleManagement.dto.CreateVehicleRequest;

import java.util.List;

public interface VehicleService {

    List<Vehicle> getAllVehicles();

    void createVehicle (Vehicle vehicle);

    void removeVehicle (int id);

    void updateVehicle (Vehicle vehicle, int id);

    Vehicle getById(int id);

    Vehicle getVehicle(CreateVehicleRequest vehicleRequest);

    CreateVehicleRequest getVehicleRequest(Vehicle vehicle);
}
