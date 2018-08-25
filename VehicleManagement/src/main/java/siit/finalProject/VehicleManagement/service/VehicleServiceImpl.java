package siit.finalProject.VehicleManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.finalProject.VehicleManagement.dao.VehicleDao;
import siit.finalProject.VehicleManagement.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

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
        vehicles.add(vehicle);
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

    }

    @Override
    public Vehicle getById(int id) {
        return null;
    }


}
