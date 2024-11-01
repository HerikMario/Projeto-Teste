package com.ProjetosDeTeste.App_Teste.domain;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "usuario")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_usuario")
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String password;

    @Column(name = "cpf")
    private String cpf;

    //private String cnpj;

    @Column(name = "saldo")
    private double balance;

    @Column(name = "telefone")
    private String telephoneNumber;

    @NotNull
    @Column(name= "data_nascimento")
    private LocalDate birthDate;

    @Embedded
    private Address address;

}
