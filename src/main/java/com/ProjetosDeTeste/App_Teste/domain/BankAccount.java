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
@Table(name = "contaBanco")
public class BankAccount {
    @Id
    @Column(name = "ID_contaBanco")
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "conta")
    private String account;

    @Column(name = "agencia")
    private String agency;
}
