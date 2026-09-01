package dev.loslca.cinematrix.services;

import dev.loslca.cinematrix.model.entity.Production;
import dev.loslca.cinematrix.model.constant.ProductionStatus;
import dev.loslca.cinematrix.repository.ProductionRepository;

import java.util.List;

public class ProductionInventoryService {

    private final ProductionRepository repository;

    public ProductionInventoryService(ProductionRepository repository) { this.repository = repository; }

    public List<Production> findAllProductions() {
        return this.repository.findAll();
    }

    public List<Production> findProductionsByName(String name) {
        return this.repository.findByNameContainingIgnoreCase(name);
    }

    public List<Production> findProductionsByStatus(ProductionStatus status) {
        return this.repository.findByStatus(status);
    }

    public List<Production> findProductionsByProducer(Long producerId) {
        return this.repository.findByProducerUserId(producerId);
    }
}