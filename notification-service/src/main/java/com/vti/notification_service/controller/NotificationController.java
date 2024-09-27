package com.vti.notification_service.controller;

import com.vti.notification_service.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class NotificationController {
    private NotificationService notificationService;

    @PostMapping("/api/v1/notifications/send")
    public ResponseEntity<String> sendNotification(@RequestBody String message) {
        notificationService.sendNotification(message);
        return ResponseEntity.ok("Notification sent");
    }
}
