package com.example.projetosea.service;

import com.example.projetosea.entity.Usuario;
import com.example.projetosea.repository.UsuarioRepository;
import com.example.projetosea.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticate(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (passwordEncoder.matches(senha, usuario.getSenha())) {
            return jwtUtil.generateToken(email);
        } else {
            throw new RuntimeException("Credenciais inválidas");
        }
    }
}
