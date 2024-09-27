package com.vti.notification_service.service;

public interface NotificationService {
    void sendNotification(String message);
    void receiveMessage(String message);
}
