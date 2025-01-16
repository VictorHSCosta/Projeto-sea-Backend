package com.example.projetosea.config;

import com.example.projetosea.entity.Usuario;
import com.example.projetosea.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class AdminConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner setupAdmin(UsuarioRepository usuarioRepository) {
        return args -> {
            String adminEmail = "admin@supremo.com"; // Pegue do .env ou properties
            if (!usuarioRepository.findByEmail(adminEmail).isPresent()) {
                Usuario adminSupremo = new Usuario();
                adminSupremo.setNome("AdminSupremo"); // Pegue do .env ou properties
                adminSupremo.setEmail(adminEmail);
                adminSupremo.setSenha(passwordEncoder.encode("senhaAdmin123")); // Pegue do .env ou properties
                adminSupremo.setIsAdm(true);
                usuarioRepository.save(adminSupremo);
                System.out.println("Admin Supremo criado com sucesso!");
            }
        };
    }
}
