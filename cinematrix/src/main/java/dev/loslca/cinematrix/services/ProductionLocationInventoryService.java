package dev.loslca.cinematrix.services;

import dev.loslca.cinematrix.model.entity.ProductionLocation;
import dev.loslca.cinematrix.repository.ProductionLocationRepository;

import java.util.List;

public class ProductionLocationInventoryService {

    private final ProductionLocationRepository repository;

    public ProductionLocationInventoryService(ProductionLocationRepository repository) { this.repository = repository; }

    public List<ProductionLocation> findAllProductionLocations() {
        return this.repository.findAll();
    }

    public List<ProductionLocation> findProductionLocationsByProduction(Long productionId) {
        return this.repository.findByProductionProductionId(productionId);
    }

    public List<ProductionLocation> findProductionLocationsByLocation(Long locationId) {
        return this.repository.findByLocationLocationId(locationId);
    }
}