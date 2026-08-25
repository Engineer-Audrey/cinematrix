package dev.loslca.cinematrix.model.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "production_cost")
public class ProductionCost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "production_cost_id")
    private Integer productionCostId;

    @ManyToOne
    @JoinColumn(name = "production_id", nullable = false)
    private Production production;

    @Column(name = "concept", nullable = false, length = 150)
    private String concept;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    public ProductionCost() {}

    public Integer getProductionCostId() { return productionCostId; }
    public void setProductionCostId(Integer productionCostId) { this.productionCostId = productionCostId; }

    public Production getProduction() { return production; }
    public void setProduction(Production production) { this.production = production; }

    public String getConcept() { return concept; }
    public void setConcept(String concept) { this.concept = concept; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}