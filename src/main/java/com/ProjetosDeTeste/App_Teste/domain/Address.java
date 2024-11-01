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
    @Column(name = "end_rua")
    private String street;

    @Column(name = "end_numero")
    private String number;

    @Column(name = "end_cep")
    private String CEP;

    @Column(name = "end_bairro")
    private String district;

    @Column(name = "end_cidade")
    private String city;

    @Column(name = "end_estado")
    private String state;
}
