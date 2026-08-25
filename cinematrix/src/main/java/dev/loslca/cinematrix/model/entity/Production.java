package dev.loslca.cinematrix.model.entity;

import dev.loslca.cinematrix.model.constant.ProductionStatus;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "production")
public class Production {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "production_id")
    private Integer productionId;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "budget", nullable = false)
    private BigDecimal budget;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ProductionStatus status = ProductionStatus.planning;

    @ManyToOne
    @JoinColumn(name = "producer_id", nullable = false)
    private User producer;

    @OneToMany(mappedBy = "production")
    private List<ProductionLocation> productionLocations;

    @OneToMany(mappedBy = "production")
    private List<ProductionCost> productionCosts;

    @OneToMany(mappedBy = "production")
    private List<ShootingSchedule> shootingSchedules;

    @OneToMany(mappedBy = "production")
    private List<Movie> movies;

    public Production() {}

    public Integer getProductionId() { return productionId; }
    public void setProductionId(Integer productionId) { this.productionId = productionId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getBudget() { return budget; }
    public void setBudget(BigDecimal budget) { this.budget = budget; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public ProductionStatus getStatus() { return status; }
    public void setStatus(ProductionStatus status) { this.status = status; }

    public User getProducer() { return producer; }
    public void setProducer(User producer) { this.producer = producer; }

    public List<ProductionLocation> getProductionLocations() { return productionLocations; }
    public void setProductionLocations(List<ProductionLocation> productionLocations) { this.productionLocations = productionLocations; }

    public List<ProductionCost> getProductionCosts() { return productionCosts; }
    public void setProductionCosts(List<ProductionCost> productionCosts) { this.productionCosts = productionCosts; }

    public List<ShootingSchedule> getShootingSchedules() { return shootingSchedules; }
    public void setShootingSchedules(List<ShootingSchedule> shootingSchedules) { this.shootingSchedules = shootingSchedules; }

    public List<Movie> getMovies() { return movies; }
    public void setMovies(List<Movie> movies) { this.movies = movies; }
}