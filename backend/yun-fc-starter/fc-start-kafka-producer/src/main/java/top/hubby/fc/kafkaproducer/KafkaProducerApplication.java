package top.hubby.fc.kafkaproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;
import top.hubby.fc.common.configuration.SpringFoxSwaggerConfig;

/**
 * @author T04856 <br>
 * @create 2023-06-19 10:00 AM <br>
 * @project fc-start-kafka-producer <br>
 */
@EnableOpenApi
@SpringBootApplication
public class KafkaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }
}
