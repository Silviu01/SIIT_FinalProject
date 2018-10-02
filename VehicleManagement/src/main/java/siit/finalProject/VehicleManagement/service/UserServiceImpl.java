package siit.finalProject.VehicleManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.finalProject.VehicleManagement.dao.UserDAOImpl;
import siit.finalProject.VehicleManagement.domain.User;
import siit.finalProject.VehicleManagement.dto.RegisterUserRequest;
import siit.finalProject.VehicleManagement.exceptionsHandler.AccessDeniedException;
import siit.finalProject.VehicleManagement.exceptionsHandler.InvalidRegisterDetails;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAOImpl userDAO;
    private List<User> registerUsers;

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void createUser(User registerUser) throws InvalidRegisterDetails {
        userDAO.createUser(registerUser);
    }

    @Override
    public void updateUser(User registerUser, int id) {
        userDAO.updateUser(registerUser, id);
    }
    /*todo
          if (id != registerUser.getId())
            throw new AccessDeniedException();
*/


    @Override
    public void removeUser(int id) {
        userDAO.removeUser(id);
    }

    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }

    @Override
    public User getUser(RegisterUserRequest registerUserRequest) throws InvalidRegisterDetails {
        User registerUser = new User();

//        getUserDetails(registerUserRequest);
        if (registerUserRequest.getUsername() == "" || registerUserRequest.getEmail() == "")
            throw new InvalidRegisterDetails();

        //todo  registerUser.getPassword() == null

        registerUser.setUsername(registerUserRequest.getUsername());
        registerUser.setPassword(registerUserRequest.getPassword());
        registerUser.setRoles(registerUserRequest.getRoles());
        registerUser.setEmail(registerUserRequest.getEmail());
        registerUser.setMobile(registerUserRequest.getMobile());
        registerUser.setAddress(registerUserRequest.getAddress());


        return registerUser;
    }

    @Override
    public User getUserDetails(RegisterUserRequest updateUserRequest) {
        User registerUser = new User();

        registerUser.setEmail(updateUserRequest.getEmail());
        registerUser.setMobile(updateUserRequest.getMobile());
        registerUser.setAddress(updateUserRequest.getAddress());

        return registerUser;
    }

    //    this is for update user
    @Override
    public RegisterUserRequest getRegisterUserRequest(User registerUser) {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();

        registerUserRequest.setEmail(registerUser.getEmail());
        registerUserRequest.setMobile(registerUser.getMobile());
        registerUserRequest.setAddress(registerUser.getAddress());

        return registerUserRequest;
    }
}
