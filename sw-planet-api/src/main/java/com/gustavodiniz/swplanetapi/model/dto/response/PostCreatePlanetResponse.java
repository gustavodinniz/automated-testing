package com.gustavodiniz.swplanetapi.model.dto.response;

import com.gustavodiniz.swplanetapi.model.Planet;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PostCreatePlanetResponse {

    private UUID planetId;
    private String name;
    private String climate;
    private String terrain;


    public static PostCreatePlanetResponse valueOf(Planet planet) {
        return PostCreatePlanetResponse.builder()
                .planetId(planet.getPlanetId())
                .name(planet.getName())
                .climate(planet.getClimate())
                .terrain(planet.getTerrain())
                .build();
    }
}
