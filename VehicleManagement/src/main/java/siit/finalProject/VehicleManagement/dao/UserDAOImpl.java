package siit.finalProject.VehicleManagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import siit.finalProject.VehicleManagement.domain.User;
import siit.finalProject.VehicleManagement.domain.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getUserByCredentials(String username, String pass) {

        try {
            return jdbcTemplate.queryForObject("SELECT * FROM users WHERE username = ? AND password = ?",
                    new RowMapper<User>() {
                        @Override
                        public User mapRow(ResultSet resultSet, int i) throws SQLException {
                            User user = new User();
                            user.setUsername(resultSet.getString("username"));
                            user.setId(resultSet.getInt("id"));
                            String rolesAsString = resultSet.getString("roles");

                            if (rolesAsString != null) {
                                String[] roles = rolesAsString.split(",");
                                Set<UserRole> userRoles = new LinkedHashSet<>();

                                for (String role : roles) {
                                    userRoles.add(UserRole.valueOf(role));
                                }
                                user.setUserRoles(userRoles);
                            }
                            return user;
                        }
                    }, username, pass);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT * FROM users", (resultSet, i) -> {
            User user = getRegisterUserFromDB(resultSet);
            return user;
        });
    }

    //toDo getAllUsers

    @Override
    public void createUser(User registerUser) {
        jdbcTemplate.update("INSERT INTO users (email, username, password, mobile, address, roles) VALUES" +
                        " (?, ?, ?, ?, ?, ?)", registerUser.getEmail(), registerUser.getUsername(), registerUser.getPassword(), registerUser.getMobile(),
                registerUser.getAddress(), "customer");

    }

    @Override
    public void updateUser(User registerUser, int id) {
        jdbcTemplate.update("UPDATE users SET email = ?, mobile = ?, address = ?" +
                        "WHERE users.id = ?", registerUser.getEmail(), registerUser.getMobile(),
                registerUser.getAddress(),id);
    }

    @Override
    public User getById(int id) {
        List<User> registerUsers = jdbcTemplate.query("SELECT * FROM users WHERE users.id = ?",
                (ResultSet resultSet, int i) -> {
                    User registerUSer = getRegisterUserFromDB(resultSet);
                    return registerUSer;
                }, id);

        return registerUsers.get(0);
    }

    private User getRegisterUserFromDB(ResultSet resultSet) throws SQLException {
        User registerUser = new User();
        registerUser.setId(resultSet.getInt("id"));
        registerUser.setEmail(resultSet.getString("email"));
        registerUser.setUsername(resultSet.getString("username"));
        registerUser.setPassword(resultSet.getString("password"));
        registerUser.setMobile(resultSet.getString("mobile"));
        registerUser.setAddress(resultSet.getString("address"));
        registerUser.setRoles(UserRole.valueOf(resultSet.getString("roles")));

        return registerUser;
    }
}
