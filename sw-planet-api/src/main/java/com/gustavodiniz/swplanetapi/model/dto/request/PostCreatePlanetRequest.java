package com.gustavodiniz.swplanetapi.model.dto.request;

import com.gustavodiniz.swplanetapi.model.Planet;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostCreatePlanetRequest {

    private String name;
    private String climate;
    private String terrain;

    public static Planet valueOf(PostCreatePlanetRequest planetRequest) {
        return Planet.builder()
                .name(planetRequest.getName())
                .climate(planetRequest.getClimate())
                .terrain(planetRequest.getTerrain())
                .build();
    }

}
