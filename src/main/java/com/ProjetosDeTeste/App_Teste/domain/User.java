package com.ProjetosDeTeste.App_Teste.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
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

    @Embedded
    private Address address;

}
