package com.gustavodiniz.swplanetapi.controller;

import com.gustavodiniz.swplanetapi.model.dto.request.PostCreatePlanetRequest;
import com.gustavodiniz.swplanetapi.model.dto.response.PostCreatePlanetResponse;
import com.gustavodiniz.swplanetapi.service.PlanetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/planets")
public class PlanetController {

    private final PlanetService planetService;

    @PostMapping
    public ResponseEntity<PostCreatePlanetResponse> create(@RequestBody PostCreatePlanetRequest planetRequest) {
        PostCreatePlanetResponse planetResponse = planetService.create(planetRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(planetResponse);
    }
}
