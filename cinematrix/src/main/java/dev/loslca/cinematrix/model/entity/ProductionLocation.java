package dev.loslca.cinematrix.model.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "production_location")
public class ProductionLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "production_location_id")
    private Integer productionLocationId;

    @ManyToOne
    @JoinColumn(name = "production_id", nullable = false)
    private Production production;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Column(name = "use_date")
    private LocalDate useDate;

    @Column(name = "notes", length = 255)
    private String notes;

    public ProductionLocation() {}

    public Integer getProductionLocationId() { return productionLocationId; }
    public void setProductionLocationId(Integer productionLocationId) { this.productionLocationId = productionLocationId; }

    public Production getProduction() { return production; }
    public void setProduction(Production production) { this.production = production; }

    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }

    public LocalDate getUseDate() { return useDate; }
    public void setUseDate(LocalDate useDate) { this.useDate = useDate; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}