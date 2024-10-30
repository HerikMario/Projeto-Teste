package com.ProjetosDeTeste.App_Teste.repositories;

import com.ProjetosDeTeste.App_Teste.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
    Optional<User> findByEmail(Object login);
    Optional<User> findByCpf(Object login);
}
