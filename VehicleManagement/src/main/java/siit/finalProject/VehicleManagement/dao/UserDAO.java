package siit.finalProject.VehicleManagement.dao;

import siit.finalProject.VehicleManagement.domain.RegisterUser;
import siit.finalProject.VehicleManagement.domain.User;

import java.util.List;

public interface UserDAO {
    User getUserByCredentials(String username, String pass);

    List<RegisterUser> getAllUsers();
    void createUser (RegisterUser registerUser);
    void updateUser (RegisterUser registerUser, int id);
    RegisterUser getById (int id);
}
