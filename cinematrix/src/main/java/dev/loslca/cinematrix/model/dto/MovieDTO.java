package dev.loslca.cinematrix.model.dto;

import dev.loslca.cinematrix.model.constant.MovieGenre;
import java.time.LocalDate;

public record MovieDTO(
        String title,
        String synopsis,
        Integer durationMinutes,
        LocalDate releaseDate,
        MovieGenre genre,
        Long directorId,
        Long productionId) {
}