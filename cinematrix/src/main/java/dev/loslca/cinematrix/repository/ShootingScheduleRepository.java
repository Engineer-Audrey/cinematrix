package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.ShootingSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShootingScheduleRepository extends JpaRepository<ShootingSchedule, Long> {
}
