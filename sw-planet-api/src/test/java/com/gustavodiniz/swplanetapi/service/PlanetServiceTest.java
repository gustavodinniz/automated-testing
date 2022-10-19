package com.gustavodiniz.swplanetapi.service;

import com.gustavodiniz.swplanetapi.model.Planet;
import com.gustavodiniz.swplanetapi.model.dto.request.PostCreatePlanetRequest;
import com.gustavodiniz.swplanetapi.model.dto.response.PostCreatePlanetResponse;
import com.gustavodiniz.swplanetapi.repository.PlanetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PlanetServiceTest {

    @InjectMocks
    private PlanetService planetService;

    @Mock
    private PlanetRepository planetRepository;

    private PostCreatePlanetRequest planetRequest;

    private PostCreatePlanetResponse planetResponse;

    private Planet planetSaved;

    @Test
    public void shouldCreatePlanetWithSuccessAndReturnsPlanetResponse() {
        givenPlanetRequest();
        givenPlanetSaved();
        givenPlanetResponse();
        givenPlanetRepositorySaveReturnsPlanetSaved();
        whenCallPlanetServiceCreate();
        thenExpectPlanetRepositorySaveCalledOnce();
        thenExpectPlanetServiceCreateRetunsPlanetResponse();
    }

    //given

    private void givenPlanetSaved() {
        planetSaved = PostCreatePlanetRequest.valueOf(planetRequest);
        planetSaved.setPlanetId(UUID.randomUUID());
    }

    private void givenPlanetRepositorySaveReturnsPlanetSaved() {
        doReturn(planetSaved).when(planetRepository).save(any(Planet.class));
    }

    private void givenPlanetResponse() {
        planetResponse = PostCreatePlanetResponse.builder()
                .planetId(planetSaved.getPlanetId())
                .name("PlanetTest")
                .climate("ClimateTest")
                .terrain("TerrainTest")
                .build();
    }

    private void givenPlanetRequest() {
        planetRequest = PostCreatePlanetRequest.builder()
                .name("PlanetTest")
                .climate("ClimateTest")
                .terrain("TerrainTest")
                .build();
    }

    //when

    private void whenCallPlanetServiceCreate() {
        planetService.create(planetRequest);
    }

    //then

    private void thenExpectPlanetRepositorySaveCalledOnce() {
        verify(planetRepository).save(any(Planet.class));
    }

    private void thenExpectPlanetServiceCreateRetunsPlanetResponse() {
        assertThat(planetResponse.getPlanetId()).isEqualTo(planetSaved.getPlanetId());
        assertThat(planetResponse.getName()).isEqualTo(planetSaved.getName());
        assertThat(planetResponse.getClimate()).isEqualTo(planetSaved.getClimate());
        assertThat(planetResponse.getTerrain()).isEqualTo(planetSaved.getTerrain());
    }

}