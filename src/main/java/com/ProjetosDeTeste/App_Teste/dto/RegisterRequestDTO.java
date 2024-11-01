package com.ProjetosDeTeste.App_Teste.dto;

import java.time.LocalDate;

public record RegisterRequestDTO<localDate>(String name, String email, String password, String cpf, String telephoneNumber, localDate Birthdate) {
    
}
