package siit.finalProject.VehicleManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.finalProject.VehicleManagement.dao.UserDAO;
import siit.finalProject.VehicleManagement.domain.User;
import siit.finalProject.VehicleManagement.exceptionsHandler.InvalidCredentials;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDAO userDAO;


    /**
     * @param username
     * @param pass
     * @return
     * @throws InvalidCredentials
     */
    @Override
    public User login(String username, String pass) throws InvalidCredentials {
        EncodePassword encode = new EncodePassword();
        encode.encodePass(pass);
        User user = userDAO.getUserByCredentials(username, encode.encodePass(pass));
        if(user == null){
            throw new InvalidCredentials();
        }
        return user;
    }


}
