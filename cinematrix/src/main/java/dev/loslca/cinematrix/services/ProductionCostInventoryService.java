package dev.loslca.cinematrix.services;

import dev.loslca.cinematrix.model.entity.ProductionCost;
import dev.loslca.cinematrix.repository.ProductionCostRepository;

import java.util.List;

public class ProductionCostInventoryService {

    private final ProductionCostRepository repository;

    public ProductionCostInventoryService(ProductionCostRepository repository) { this.repository = repository; }

    public List<ProductionCost> findAllProductionCosts() {
        return this.repository.findAll();
    }

    public List<ProductionCost> findProductionCostsByProduction(Long productionId) {
        return this.repository.findByProductionProductionId(productionId);
    }

    public List<ProductionCost> findProductionCostsByConcept(String concept) {
        return this.repository.findByConceptContainingIgnoreCase(concept);
    }
}