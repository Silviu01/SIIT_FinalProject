package siit.finalProject.VehicleManagement.service;

import siit.finalProject.VehicleManagement.domain.User;
import siit.finalProject.VehicleManagement.exceptionsHandler.InvalidCredentials;

public interface LoginService {

    User login(String user, String pass)throws InvalidCredentials;
}
