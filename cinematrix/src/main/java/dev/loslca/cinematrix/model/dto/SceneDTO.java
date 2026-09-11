package dev.loslca.cinematrix.model.dto;

import dev.loslca.cinematrix.model.constant.TimeOfDay;

public record SceneDTO(
        Integer sceneNumber,
        String description,
        TimeOfDay timeOfDay,
        Long movieId,
        Long locationId) {
}