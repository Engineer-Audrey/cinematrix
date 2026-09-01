package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    public List<Location> findByNameContainingIgnoreCase(String name);
    public List<Location> findByCity(String city);
    public List<Location> findByCountry(String country);
}