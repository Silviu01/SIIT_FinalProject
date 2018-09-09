package siit.finalProject.VehicleManagement.domain;

import siit.finalProject.VehicleManagement.service.EncodePassword;

public class RegisterUser {

    private int id;
    private String email;
    private String username;
    private String password;
    private String mobile;
    private String address;
    private UserRole roles;

    public RegisterUser() {
    }

    public RegisterUser(int id, String email, String username, String password, String mobile, String address, UserRole roles) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
        this.address = address;
        this.roles = roles;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        EncodePassword encode = new EncodePassword();
        this.password = encode.encodePass(password);
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
