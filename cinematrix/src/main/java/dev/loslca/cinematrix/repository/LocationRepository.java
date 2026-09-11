package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    public List<Location> findByNameContainingIgnoreCase(String name);
    public List<Location> findByCityContainingIgnoreCase(String city);
    public List<Location> findByCountryContainingIgnoreCase(String country);
}