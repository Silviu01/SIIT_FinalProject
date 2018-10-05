package siit.finalProject.VehicleManagement.domain;

import siit.finalProject.VehicleManagement.service.EncodePassword;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Admin can get log in with valid username and password.
 * Admin can view and modify all registered user details.
 * Admin can upload vehicle information like Vehicle name, Manufacture Year, Model Color, Cost.
 *
 *
 * Customer needs to register with the application to get unique username and password.
 * The customer can log in with valid username and password.
 * Customer views Vehicles and sends a request to sales manager for cost and delivery date.
 * The customer can view sales manager response
 *
 * The dealer needs to register with the application to get unique username and password.
 * The dealer can enter into the application with valid username and password.
 * The dealer can upload vehicle information such as vehicle name, manufacture year, model color and cost.
 *
 */

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
