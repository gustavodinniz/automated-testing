package com.gustavodiniz.swplanetapi.service;

import com.gustavodiniz.swplanetapi.model.Planet;
import com.gustavodiniz.swplanetapi.model.dto.request.PostCreatePlanetRequest;
import com.gustavodiniz.swplanetapi.model.dto.response.PostCreatePlanetResponse;
import com.gustavodiniz.swplanetapi.repository.PlanetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlanetService {

    private final PlanetRepository planetRepository;

    public PostCreatePlanetResponse create(PostCreatePlanetRequest planetRequest) {
        log.info("starting planet creation...");
        Planet planet = PostCreatePlanetRequest.valueOf(planetRequest);
        Planet planetSaved = planetRepository.save(planet);
        log.info("planet created successfully with id: {}", planetSaved.getPlanetId());
        return PostCreatePlanetResponse.valueOf(planetSaved);
    }
}
