package top.hubby.fc.web.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author T04856 <br>
 * @create 2023-06-16 9:27 AM <br>
 * @project start-springboot <br>
 */
@RestController
public class HelloController {

    private static final String PGSQL_HEALTH = "SELECT 1 FROM pg_database LIMIT 1";
    private static final String MYSQL_HEALTH = "SELECT 1 FROM DUAL LIMIT 1";

    @Resource private JdbcTemplate jdbcTemplate;

    @GetMapping("/actuator/health")
    public String health() {

        try {
            jdbcTemplate.execute(PGSQL_HEALTH);
        } catch (DataAccessException e) {
            return "DB Is Down!";
        }

        return "DB Is OK!";
    }

    @GetMapping("/ping")
    public String listHeaders() {
        return "PONG";
    }
}
