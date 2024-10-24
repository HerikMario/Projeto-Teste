package com.ProjetosDeTeste.App_Teste.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usinas")
public class SolarPlant {
    @Id
    @Column(name = "ID_usina")
    private Long id;

    @Column(name = "nome")
    private String nameSolarPlant;

    @Column(name = "capacidade_total")
    private Long fullCapacity;

    @Column(name = "capacidade_restante")
    private Long remainingCapacity;

    @Column(name = "valor_vitis")
    private double vitisValue;

    @Column(name = "localizacao")
    private String localization;
}
