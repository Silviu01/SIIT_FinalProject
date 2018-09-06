package siit.finalProject.VehicleManagement.service;

import org.springframework.stereotype.Service;
import siit.finalProject.VehicleManagement.domain.User;

@Service
public class SecurityService {


    private ThreadLocal<User> currentUser;

    public void setCurrentUser(User user) {
        this.currentUser = new ThreadLocal<>();
        this.currentUser.set(user);
    }

    public User getCurrentUser() {
        if (this.currentUser != null) return this.currentUser.get();
        else return null;

    }
}
