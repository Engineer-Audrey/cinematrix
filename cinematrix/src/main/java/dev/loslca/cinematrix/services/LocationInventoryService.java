package dev.loslca.cinematrix.services;

import dev.loslca.cinematrix.model.entity.Location;
import dev.loslca.cinematrix.repository.LocationRepository;

import java.util.List;

public class LocationInventoryService {

    private final LocationRepository repository;

    public LocationInventoryService(LocationRepository repository) { this.repository = repository; }

    public List<Location> findAllLocations() {
        return this.repository.findAll();
    }

    public List<Location> findLocationsByName(String name) {
        return this.repository.findByNameContainingIgnoreCase(name);
    }

    public List<Location> findLocationsByCity(String city) {
        return this.repository.findByCity(city);
    }

    public List<Location> findLocationsByCountry(String country) {
        return this.repository.findByCountry(country);
    }
}