package siit.finalProject.VehicleManagement.service;


import siit.finalProject.VehicleManagement.domain.User;
import siit.finalProject.VehicleManagement.dto.RegisterUserRequest;
import siit.finalProject.VehicleManagement.exceptionsHandler.InvalidRegisterDetails;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void createUser(User registerUser) throws InvalidRegisterDetails;
    void updateUser (User registerUser, int id);
    void removeUser(int id);
    User getById (int id);
    User getUser (RegisterUserRequest registerUserRequest) throws InvalidRegisterDetails;
    User getUserDetails (RegisterUserRequest registerUserRequest);
    RegisterUserRequest getRegisterUserRequest(User registerUser);
}
