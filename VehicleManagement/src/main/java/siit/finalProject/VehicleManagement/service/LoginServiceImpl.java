package siit.finalProject.VehicleManagement.service;

import siit.finalProject.VehicleManagement.domain.User;

import java.util.ArrayList;
import java.util.List;

public class LoginServiceImpl implements LoginService {

    List<User> users = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void createUser(User user) {
        users.add(user);
    }


}
