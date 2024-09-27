package com.vti.notification_service.service;

import com.vti.notification_service.configuration.RabbitMQConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class NotificationServiceImpl implements NotificationService {
    private static final Logger logger = Logger.getLogger(NotificationServiceImpl.class.getName());
    private final AmqpTemplate amqpTemplate;

    public NotificationServiceImpl(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @Override
    public void sendNotification(String message) {
        try {
            amqpTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, message);
            logger.info("Notification sent successfully: " + message);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to send notification: " + message, e);
        }
    }

    @Override
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        try {
            processNotification(message);
            logger.info("Received and processed notification: " + message);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error processing notification: " + message, e);
        }
    }

    private void processNotification(String message) {
        try {
            // Add your notification handling logic here (e.g., sending an email)
            // For now, just logging the message
            logger.info("Processing notification: " + message);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error processing notification: " + message, e);
        }
    }
}
