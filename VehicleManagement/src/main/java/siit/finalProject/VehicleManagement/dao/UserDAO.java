package siit.finalProject.VehicleManagement.dao;

import siit.finalProject.VehicleManagement.domain.User;

import java.util.List;

public interface UserDAO {
    User getUserByCredentials(String username, String pass);

    List<User> getAllUsers();
    void createUser (User registerUser);
    void updateUser (User registerUser, int id);
    User getById (int id);
}
