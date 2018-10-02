package siit.finalProject.VehicleManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    private static final int PORT = 5432;
    private static final String DB = "VehicleSystem";       //"VehicleSystem";
    private static final String USER = "postgres";
    private static final String PASSWORD = "hetfield"; //postgres"

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        String url = new StringBuilder()
                .append("jdbc:")
                .append("postgresql")
                .append("://")
                .append("localhost")
                .append(":")
                .append(PORT)
                .append("/")
                .append(DB) //db
                .append("?user=")
                .append(USER)
                .append("&password=")
                .append(PASSWORD).toString();
        return new SingleConnectionDataSource(url, false);
    }

}
