package siit.finalProject.VehicleManagement.dao;

import siit.finalProject.VehicleManagement.domain.RegisterUser;
import siit.finalProject.VehicleManagement.domain.User;

public interface UserDAO {
    User getUserByCredentials(String username, String pass);

    void createUser (RegisterUser registerUser);
    void updateUser (RegisterUser registerUser, int id);
    RegisterUser getById (int id);
}
