package com.ProjetosDeTeste.App_Teste.controllers;

import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ProjetosDeTeste.App_Teste.domain.User;
import com.ProjetosDeTeste.App_Teste.dto.LoginRequestDTO;
import com.ProjetosDeTeste.App_Teste.dto.RegisterRequestDTO;
import com.ProjetosDeTeste.App_Teste.dto.ResponseDTO;
import com.ProjetosDeTeste.App_Teste.infra.security.TokenService;
import com.ProjetosDeTeste.App_Teste.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO body){
        User user = this.userRepository.findByCpf(body.cpf()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(user.getPassword(), body.password())){
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getCpf(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody RegisterRequestDTO body){
        Optional<User> user = this.userRepository.findByCpf(body.cpf());
        if(user.isEmpty()){//verifica
            User newUser = new User();
            newUser.setName(body.name());
            newUser.setEmail(body.email());
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setTelephoneNumber(body.telephoneNumber());
            newUser.setCpf(body.cpf());
            // newUser.setBirthDate(body.birthDate());
            this.userRepository.save(newUser);
            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getCpf(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
