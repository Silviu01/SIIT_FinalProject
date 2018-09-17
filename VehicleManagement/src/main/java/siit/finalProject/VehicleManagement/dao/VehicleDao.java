package siit.finalProject.VehicleManagement.dao;

import siit.finalProject.VehicleManagement.domain.Vehicle;

import java.util.List;

public interface VehicleDao {

    List<Vehicle> getAllVehicles();

    void createVehicle (Vehicle vehicle);

    void removeVehicle (long id);

    void updateVehicle (Vehicle vehicle, long id);

    Vehicle getById (long id);
}
