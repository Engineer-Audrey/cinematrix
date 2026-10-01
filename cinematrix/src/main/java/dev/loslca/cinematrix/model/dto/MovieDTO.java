package dev.loslca.cinematrix.model.dto;

import dev.loslca.cinematrix.model.constant.MovieGenre;
import java.time.LocalDate;
import java.util.List;

public record MovieDTO(
        String title,
        String synopsis,
        Integer durationMinutes,
        LocalDate releaseDate,
        MovieGenre genre,
        String director,
        List<SceneDTO> scenes,
        List<ActorDTO> actors) {
}