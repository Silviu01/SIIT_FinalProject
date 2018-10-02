package siit.finalProject.VehicleManagement.dao;

import siit.finalProject.VehicleManagement.domain.User;
import siit.finalProject.VehicleManagement.exceptionsHandler.InvalidRegisterDetails;

import java.util.List;

public interface UserDAO {
    User getUserByCredentials(String username, String pass);

    List<User> getAllUsers();
    void createUser (User registerUser) throws InvalidRegisterDetails;
    void updateUser (User registerUser, int id);
    void removeUser(int id);
    User getById (int id);
}
