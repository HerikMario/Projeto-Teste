package com.ProjetosDeTeste.App_Teste.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Embeddable
public class Address {
    @Column(name = "endRua")
    private String street;

    @Column(name = "endNumero")
    private int number;

    @Column(name = "endCep")
    private String CEP;

    @Column(name = "endBairro")
    private String district;

    @Column(name = "endCidade")
    private String city;

    @Column(name = "endEstado")
    private String state;
}
