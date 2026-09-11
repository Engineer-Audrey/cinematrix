package dev.loslca.cinematrix.model.dto;

public record ProductionDTO(
        Double budget,
        Double actualCost,
        Long movieId) {
}