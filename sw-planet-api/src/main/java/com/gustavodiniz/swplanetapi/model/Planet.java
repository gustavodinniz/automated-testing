package com.gustavodiniz.swplanetapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_planets")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID planetId;
    private String name;
    private String climate;
    private String terrain;
}
