package com.ProjetosDeTeste.App_Teste.domain;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Long id;

    private String name;
    private String email;
    private String password;
    private String cpf;
    private String cnpj;
    private double saldo;
    private String telephoneNumber;

    @Embedded
    private Address address;

}
