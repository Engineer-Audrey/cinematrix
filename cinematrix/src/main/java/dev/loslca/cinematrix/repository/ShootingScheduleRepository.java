package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.ShootingSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShootingScheduleRepository extends JpaRepository<ShootingSchedule, Long> {
    public List<ShootingSchedule> findByProductionProductionId(Long productionId);
    public List<ShootingSchedule> findByLocationLocationId(Long locationId);
    public List<ShootingSchedule> findByShootingDate(LocalDate shootingDate);
}