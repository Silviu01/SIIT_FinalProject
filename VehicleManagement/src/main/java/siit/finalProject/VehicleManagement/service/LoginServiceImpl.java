package siit.finalProject.VehicleManagement.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.finalProject.VehicleManagement.dao.UserDAO;
import siit.finalProject.VehicleManagement.domain.User;
import siit.finalProject.VehicleManagement.exceptionsHandler.InvalidCredentials;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User login(String username, String pass) throws InvalidCredentials {

        encodePass(pass);
        User user = userDAO.getUserByCredentials(username, encodePass(pass));



        if(user == null){
            throw new InvalidCredentials();
        }
        return user;
    }

    private String encodePass(String pass) throws RuntimeException {

        try {
            return DigestUtils.md5Hex(pass);
        } catch (Exception ex) {
            throw new RuntimeException("Encoding problem");
        }
    }

    // TODO !!! delete this !!!
    public static void main(String[] args) {
        LoginServiceImpl loginService = new LoginServiceImpl();
        String encoded = loginService.encodePass("222");
        System.out.println(encoded);
    }
}
