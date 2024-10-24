package Repositories;

import com.ProjetosDeTeste.App_Teste.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
