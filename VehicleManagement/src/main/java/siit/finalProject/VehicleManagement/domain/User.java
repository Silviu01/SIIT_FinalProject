package siit.finalProject.VehicleManagement.domain;

import java.util.LinkedHashSet;
import java.util.Set;

public class User {

    private String username;
    private Set<UserRole> userRoles;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    /**
     * @return
     */
    public Set<String> getRolesAsString() {
        Set<String> result = new LinkedHashSet<>();

        if (userRoles != null){
            userRoles.stream().forEach((UserRole userRole) -> {
                result.add(userRole.name());
            });
        }

        return result;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

}
