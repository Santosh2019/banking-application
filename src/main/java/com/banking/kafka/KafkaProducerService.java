package com.banking.kafka;

import com.banking.dto.CustomerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendCustomerCreatedEvent(CustomerDto customerDto) {
        logger.info("Publishing event -> CustomerCreated: {}", customerDto);
        kafkaTemplate.send("customer-topic", "CustomerCreated", customerDto);
    }

    public void sendCustomerDeletedEvent(CustomerDto customerDto) {
        logger.info("Publishing event -> CustomerDeleted: {}", customerDto);
        kafkaTemplate.send("customer-topic", "CustomerDeleted", customerDto);
    }
}
