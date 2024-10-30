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
    private UserRepository repository;
    @Autowired

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.repository.findByEmail( email).orElseThrow(()-> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
    
}
