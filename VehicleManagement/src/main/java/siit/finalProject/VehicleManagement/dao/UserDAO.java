package siit.finalProject.VehicleManagement.dao;

import siit.finalProject.VehicleManagement.domain.User;

public interface UserDAO {
    User getUserByCredentials(String username, String pass);
}
