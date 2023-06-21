package top.hubby.fc.kafkaproducer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.hubby.fc.kafkaproducer.cn.salesorder.SalesOrderCN;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author T04856 <br>
 * @create 2023-06-19 10:16 AM <br>
 * @project yun-fc-starter <br>
 */
@Slf4j
@RestController
public class ProducerController {

    private static final String TOPIC = "salesOrder";

    @Resource private KafkaTemplate<String, SpecificRecordBase> kafkaTemplate;

    @Resource private ObjectMapper objectMapper;

    @SneakyThrows
    @PostMapping("/send-to-cn")
    public void send2Cn() {

    String json =
        "{\n"
            + "  \"header\": {\n"
            + "    \"domain\": \"test_28cbb10cd800\",\n"
            + "    \"eventSource\": \"test_af7589eccb7d\",\n"
            + "    \"isSynthetic\": \"test_9961ad000df8\",\n"
            + "    \"correlationId\": \"test_2154ec7c84eb\"\n"
            + "  },\n"
            + "  \"details\": {\n"
            + "    \"id\": 84,\n"
            + "    \"name\": \"test_76452569823e\"\n"
            + "  }\n"
            + "}";

        SendResult<String, SpecificRecordBase> sendResult =
                kafkaTemplate
                        .send(TOPIC, "key", objectMapper.readValue(json, SalesOrderCN.class))
                        .get(1000, TimeUnit.SECONDS);

        log.info("send result: {}", sendResult);
    }
}
