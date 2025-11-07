package com.banking.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @KafkaListener(topics = "customer-topic", groupId = "customer-consumer-group")
    public void consumeCustomerEvents(Object event) {
        if (event.toString().contains("CustomerCreated")) {
            logger.info("Sending Welcome Email to customer...");
        } else if (event.toString().contains("CustomerDeleted")) {
            logger.info("Sending Account Deletion Notification...");
        }
    }

}
