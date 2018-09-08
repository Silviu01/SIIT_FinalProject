package siit.finalProject.VehicleManagement.service;


import siit.finalProject.VehicleManagement.domain.RegisterUser;
import siit.finalProject.VehicleManagement.dto.RegisterUserRequest;

public interface UserService {

    void createUser(RegisterUser registerUser);
    void updateUser (RegisterUser registerUser, int id);
    RegisterUser getById (int id);
    RegisterUser getUser (RegisterUserRequest registerUserRequest);
    RegisterUserRequest getRegisterUserRequest(RegisterUser registerUser);
}