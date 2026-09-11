package dev.loslca.cinematrix.services;

import dev.loslca.cinematrix.model.dto.LocationDTO;
import dev.loslca.cinematrix.model.entity.Location;
import dev.loslca.cinematrix.repository.LocationRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class LocationInventoryService {

    private final LocationRepository repository;

    public LocationInventoryService(LocationRepository repository) {
        this.repository = repository;
    }

    public List<Location> findAllLocations() {
        return this.repository.findAll();
    }

    public List<Location> findLocationsByName(String name) {
        return this.repository.findByNameContainingIgnoreCase(name);
    }

    public List<Location> findLocationsByCity(String city) {
        return this.repository.findByCityContainingIgnoreCase(city);
    }

    public List<Location> findLocationsByCountry(String country) {
        return this.repository.findByCountryContainingIgnoreCase(country);
    }

    public LocationDTO createLocation(LocationDTO locationRequest) throws EntityNotFoundException {
        Location location = new Location();
        setAttributesFromDTO(locationRequest, location);
        this.repository.save(location);
        return locationRequest;
    }

    public LocationDTO updateLocation(Long locationId, LocationDTO locationRequest) throws EntityNotFoundException {
        Location location = this.repository.findById(locationId)
                .orElseThrow(() -> new EntityNotFoundException("Location with id " + locationId + " not found"));
        setAttributesFromDTO(locationRequest, location);
        this.repository.save(location);
        return locationRequest;
    }

    public void deleteLocation(Long locationId) throws EntityNotFoundException {
        Location location = this.repository.findById(locationId)
                .orElseThrow(() -> new EntityNotFoundException("Location with id " + locationId + " not found"));
        this.repository.delete(location);
    }

    public void setAttributesFromDTO(LocationDTO request, Location location) {
        location.setName(request.name());
        location.setCity(request.city());
        location.setCountry(request.country());
    }
}