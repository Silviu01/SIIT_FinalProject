package siit.finalProject.VehicleManagement.service;


import siit.finalProject.VehicleManagement.domain.User;
import siit.finalProject.VehicleManagement.dto.RegisterUserRequest;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void createUser(User registerUser);
    void updateUser (User registerUser, int id);
    User getById (int id);
    User getUser (RegisterUserRequest registerUserRequest);
    RegisterUserRequest getRegisterUserRequest(User registerUser);
}
