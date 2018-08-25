package siit.finalProject.VehicleManagement.service;

import siit.finalProject.VehicleManagement.domain.User;

import java.util.List;

public interface LoginService {

    List<User> getAllUsers();

    void createUser(User user);
}
