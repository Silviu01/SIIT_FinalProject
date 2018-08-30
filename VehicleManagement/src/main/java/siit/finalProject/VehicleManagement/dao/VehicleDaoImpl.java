package siit.finalProject.VehicleManagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import siit.finalProject.VehicleManagement.domain.Vehicle;
import siit.finalProject.VehicleManagement.domain.VehicleStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleDaoImpl implements VehicleDao {
    List<Vehicle> vehicleList = new ArrayList<>();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Vehicle> getAllVehicles() {
        return jdbcTemplate.query("SELECT * FROM vehicles", (resultSet, i) -> {
            Vehicle vehicle = getVehicleFromDB(resultSet);
            return vehicle;
        });
    }

    @Override
    public void createVehicle(Vehicle vehicle) {
        List<Vehicle> vehicles = getAllVehicles();
        if (!vehicles.contains(vehicle)) {
            jdbcTemplate.update("INSERT INTO vehicles (id, vmodel, vname, vyear, vcolor, vcost, vstatus) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)", System.currentTimeMillis(), vehicle.getVmodel(), vehicle.getVname(),
                    vehicle.getVyear(), vehicle.getVcolor(), vehicle.getVcost(), "Available");
        }
    }

    @Override
    public void updateVehicle(Vehicle vehicle, long id) {
        jdbcTemplate.update("UPDATE vehicles SET vmodel = ?, vname = ?, vyear = ?, vcolor = ?, vcost = ?, vstatus = ? WHERE vehicles.id= ?",
                vehicle.getVmodel(), vehicle.getVname(), vehicle.getVyear(), vehicle.getVcolor(), vehicle.getVcost(), "Available", id);
    }

    @Override
    public Vehicle getById(long id) {
        List<Vehicle> vehicles = jdbcTemplate.query("SELECT * FROM vehicles WHERE vehicles.id= ?",
                (resultSet, i) -> {
                    Vehicle vehicle = getVehicleFromDB(resultSet);
                    return vehicle;
                }, id);
        return vehicles.get(0);
    }

    @Override
    public void removeVehicle(long id) {
    }



    private Vehicle getVehicleFromDB(ResultSet resultSet) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(resultSet.getLong("id"));
        vehicle.setVmodel(resultSet.getString("vmodel"));
        vehicle.setVname(resultSet.getString("vname"));
        vehicle.setVyear(resultSet.getString("vyear"));
        vehicle.setVcolor(resultSet.getString("vcolor"));
        vehicle.setVcost(resultSet.getString("vcost"));
        vehicle.setVstatus(VehicleStatus.valueOf(resultSet.getString("vstatus")));
        return vehicle;
    }
}
