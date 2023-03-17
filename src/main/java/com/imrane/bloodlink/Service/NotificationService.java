package com.imrane.bloodlink.Service;


import com.imrane.bloodlink.Entity.Notification;
import com.imrane.bloodlink.Repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    private void validateNotification(Notification notification) {
        if (notification.getTitle() == null || notification.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Notification title cannot be null or empty");
        }
        if (notification.getBody() == null || notification.getBody().isEmpty()) {
            throw new IllegalArgumentException("Notification body cannot be null or empty");
        }
    }

    public void markNotificationAsSeen(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new NoSuchElementException("Notification with ID " + notificationId + " not found"));
        notification.setSeen(true);
        notificationRepository.save(notification);
    }

    public Notification createNotification(Notification notification) {
        validateNotification(notification);
        return notificationRepository.save(notification);
    }
}
