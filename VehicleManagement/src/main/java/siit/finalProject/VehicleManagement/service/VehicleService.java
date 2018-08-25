package siit.finalProject.VehicleManagement.service;

import siit.finalProject.VehicleManagement.domain.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> getAllVehicles();

    void createVehicle (Vehicle vehicle);

    void removeVehicle (int id);

    void updateVehicle (Vehicle vehicle, int id);

    Vehicle getById(int id);
}
