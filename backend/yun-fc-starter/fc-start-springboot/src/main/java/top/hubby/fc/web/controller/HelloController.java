package top.hubby.fc.web.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author T04856 <br>
 * @create 2023-06-16 9:27 AM <br>
 * @project start-springboot <br>
 */
@RestController
public class HelloController {

    @Resource private JdbcTemplate jdbcTemplate;

    @GetMapping("/actuator/health")
    public String listHeaders(@RequestHeader Map<String, String> headers) {

        try {
            jdbcTemplate.execute("SELECT 1 FROM DUAL");
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
