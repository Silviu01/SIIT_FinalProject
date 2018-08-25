package siit.finalProject.VehicleManagement.dao;

import siit.finalProject.VehicleManagement.domain.Vehicle;

import java.util.List;

public interface VehicleDao {

    List<Vehicle> getAllVehicles();

    void createVehicle (Vehicle vehicle);

    void removeVehicle (int id);

    void updateVehicle (Vehicle vehicle, int id);

    void  getById (int id);
}
