package dev.loslca.cinematrix.model.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "shooting_schedule")
public class ShootingSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shooting_schedule_id")
    private Integer shootingScheduleId;

    @ManyToOne
    @JoinColumn(name = "production_id", nullable = false)
    private Production production;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "shooting_date", nullable = false)
    private LocalDate shootingDate;

    @Column(name = "description", length = 255)
    private String description;

    public ShootingSchedule() {}

    public Integer getShootingScheduleId() { return shootingScheduleId; }
    public void setShootingScheduleId(Integer shootingScheduleId) { this.shootingScheduleId = shootingScheduleId; }

    public Production getProduction() { return production; }
    public void setProduction(Production production) { this.production = production; }

    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }

    public LocalDate getShootingDate() { return shootingDate; }
    public void setShootingDate(LocalDate shootingDate) { this.shootingDate = shootingDate; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}