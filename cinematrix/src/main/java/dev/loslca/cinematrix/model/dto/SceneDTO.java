package dev.loslca.cinematrix.model.dto;

import dev.loslca.cinematrix.model.constant.TimeOfDay;

public record SceneDTO(
        Integer sceneNumber,
        String description,
        TimeOfDay timeOfDay,
        String location) {
}