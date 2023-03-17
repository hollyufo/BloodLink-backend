package com.imrane.bloodlink.Repository;

import com.imrane.bloodlink.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
