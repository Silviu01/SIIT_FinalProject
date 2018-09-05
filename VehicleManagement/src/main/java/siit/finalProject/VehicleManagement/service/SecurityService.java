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
        return this.currentUser != null ?
                this.currentUser.get() : null;

    }
}
