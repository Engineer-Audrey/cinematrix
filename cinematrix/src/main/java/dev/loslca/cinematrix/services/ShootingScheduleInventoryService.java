package dev.loslca.cinematrix.services;

import dev.loslca.cinematrix.model.entity.ShootingSchedule;
import dev.loslca.cinematrix.repository.ShootingScheduleRepository;

import java.time.LocalDate;
import java.util.List;

public class ShootingScheduleInventoryService {

    private final ShootingScheduleRepository repository;

    public ShootingScheduleInventoryService(ShootingScheduleRepository repository) { this.repository = repository; }

    public List<ShootingSchedule> findAllShootingSchedules() {
        return this.repository.findAll();
    }

    public List<ShootingSchedule> findShootingSchedulesByProduction(Long productionId) {
        return this.repository.findByProductionProductionId(productionId);
    }

    public List<ShootingSchedule> findShootingSchedulesByLocation(Long locationId) {
        return this.repository.findByLocationLocationId(locationId);
    }

    public List<ShootingSchedule> findShootingSchedulesByDate(LocalDate shootingDate) {
        return this.repository.findByShootingDate(shootingDate);
    }
}