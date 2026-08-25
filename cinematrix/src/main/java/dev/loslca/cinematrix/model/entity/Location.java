package dev.loslca.cinematrix.model.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Integer locationId;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "cost_per_day")
    private BigDecimal costPerDay;

    @OneToMany(mappedBy = "location")
    private List<ProductionLocation> productionLocations;

    @OneToMany(mappedBy = "location")
    private List<ShootingSchedule> shootingSchedules;

    @OneToMany(mappedBy = "location")
    private List<Scene> scenes;

    public Location() {}

    public Integer getLocationId() { return locationId; }
    public void setLocationId(Integer locationId) { this.locationId = locationId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public BigDecimal getCostPerDay() { return costPerDay; }
    public void setCostPerDay(BigDecimal costPerDay) { this.costPerDay = costPerDay; }

    public List<ProductionLocation> getProductionLocations() { return productionLocations; }
    public void setProductionLocations(List<ProductionLocation> productionLocations) { this.productionLocations = productionLocations; }

    public List<ShootingSchedule> getShootingSchedules() { return shootingSchedules; }
    public void setShootingSchedules(List<ShootingSchedule> shootingSchedules) { this.shootingSchedules = shootingSchedules; }

    public List<Scene> getScenes() { return scenes; }
    public void setScenes(List<Scene> scenes) { this.scenes = scenes; }
}