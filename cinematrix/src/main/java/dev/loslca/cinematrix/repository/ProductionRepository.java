package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.Production;
import dev.loslca.cinematrix.model.constant.ProductionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductionRepository extends JpaRepository<Production, Long> {
    public List<Production> findByNameContainingIgnoreCase(String name);
    public List<Production> findByStatus(ProductionStatus status);
    public List<Production> findByProducerUserId(Long producerId);
}