package siit.finalProject.VehicleManagement.domain;

import siit.finalProject.VehicleManagement.service.EncodePassword;

import java.util.LinkedHashSet;
import java.util.Set;

public class User {

    private String username;
    private Set<UserRole> userRoles;
    private int id;
    private String email;
    private String password;
    private String mobile;
    private String address;
    private UserRole roles;

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
        if (userRoles != null) {
            userRoles.stream().forEach((UserRole userRole) -> {
                result.add(userRole.name());
            });
        }
        return result;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        EncodePassword encodePassword = new EncodePassword();
        this.password = encodePassword.encodePass(password);
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserRole getRoles() {
        return roles;
    }

    public void setRoles(UserRole roles) {
        this.roles = roles;
    }

}
