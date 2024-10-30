package com.ProjetosDeTeste.App_Teste.infra.security;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.ProjetosDeTeste.App_Teste.domain.User;
import com.ProjetosDeTeste.App_Teste.repositories.UserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        User user = this.repository.findByCpf(cpf).orElseThrow(()-> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(user.getCpf(), user.getPassword(), new ArrayList<>());
    }
    
}
