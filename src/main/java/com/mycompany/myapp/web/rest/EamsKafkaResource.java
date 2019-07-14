package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.EamsKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/eams-kafka")
public class EamsKafkaResource {

    private final Logger log = LoggerFactory.getLogger(EamsKafkaResource.class);

    private EamsKafkaProducer kafkaProducer;

    public EamsKafkaResource(EamsKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
