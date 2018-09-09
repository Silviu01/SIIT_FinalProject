package siit.finalProject.VehicleManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.finalProject.VehicleManagement.dao.UserDAOImpl;
import siit.finalProject.VehicleManagement.domain.RegisterUser;
import siit.finalProject.VehicleManagement.dto.RegisterUserRequest;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAOImpl userDAO;
    private List<RegisterUser> registerUsers;

    @Override
    public void createUser(RegisterUser registerUser) {
        userDAO.createUser(registerUser);
    }

    @Override
    public void updateUser(RegisterUser registerUser, int id) {
        userDAO.updateUser(registerUser, id);
    }

    @Override
    public RegisterUser getById(int id) {
        return userDAO.getById(id);
    }

    @Override
    public RegisterUser getUser(RegisterUserRequest registerUserRequest) {
        RegisterUser registerUser = new RegisterUser();

        registerUser.setEmail(registerUserRequest.getEmail());
        registerUser.setUsername(registerUserRequest.getUsername());
        registerUser.setPassword(registerUserRequest.getPassword());
        registerUser.setMobile(registerUserRequest.getMobile());
        registerUser.setAddress(registerUserRequest.getAddress());
        registerUser.setRoles(registerUserRequest.getRoles());

        return registerUser;
    }

//    this is for update user
    @Override
    public RegisterUserRequest getRegisterUserRequest(RegisterUser registerUser) {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();

        registerUserRequest.setEmail(registerUser.getEmail());
//        registerUserRequest.setUsername(registerUser.getUsername());
//        registerUserRequest.setPassword(registerUser.getPassword());
        registerUserRequest.setMobile(registerUser.getMobile());
        registerUserRequest.setAddress(registerUser.getAddress());

        return registerUserRequest;
    }
}
