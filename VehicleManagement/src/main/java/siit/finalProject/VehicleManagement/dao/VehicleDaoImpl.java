package siit.finalProject.VehicleManagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import siit.finalProject.VehicleManagement.domain.Vehicle;
import siit.finalProject.VehicleManagement.domain.VehicleStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class VehicleDaoImpl implements VehicleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Vehicle> getAllVehicles() {
        return jdbcTemplate.query("SELECT * FROM vehicles", (resultSet, i) -> {
            Vehicle vehicle = new Vehicle();
            vehicle.setId(resultSet.getInt("id"));
            vehicle.setVmodel(resultSet.getString("vmodel"));
            vehicle.setVname(resultSet.getString("vname"));
            vehicle.setVyear(resultSet.getString("vyear"));
            vehicle.setVcolor(resultSet.getString("vcolor"));
            vehicle.setVcost(resultSet.getString("vcost"));
            vehicle.setVstatus(VehicleStatus.valueOf(resultSet.getString("vstatus")));

            return vehicle;
        });
    }

    @Override
    public void createVehicle(Vehicle vehicle) {
    }

    @Override
    public void removeVehicle(int id) {
     }

    @Override
    public void updateVehicle(Vehicle vehicle, int id) {

    }

    @Override
    public void getById(int id) {

    }
}
