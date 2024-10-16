package com.ProjetosDeTeste.App_Teste.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public abstract class User {
    private String name;
    private String email;
    private String password;
    private int id;
    private String cpf;
    private String cnpj;
    private Address address;
}
