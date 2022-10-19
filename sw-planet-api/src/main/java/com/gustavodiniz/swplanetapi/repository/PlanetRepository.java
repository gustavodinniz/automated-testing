package com.gustavodiniz.swplanetapi.repository;

import com.gustavodiniz.swplanetapi.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlanetRepository extends JpaRepository<Planet, UUID> {
}
