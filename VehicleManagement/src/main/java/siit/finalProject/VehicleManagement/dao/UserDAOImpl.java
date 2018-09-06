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
}
