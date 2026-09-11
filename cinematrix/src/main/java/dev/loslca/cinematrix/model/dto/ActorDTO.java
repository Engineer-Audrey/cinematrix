package dev.loslca.cinematrix.model.dto;

import java.time.LocalDate;

public record ActorDTO(
        String name,
        String nationality,
        LocalDate birthDate) {
}