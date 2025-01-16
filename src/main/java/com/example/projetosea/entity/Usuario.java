package com.example.projetosea.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    private String senha;

    private Boolean admAuth;

    private Boolean perfilPreenchido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "informacoes_id", referencedColumnName = "id")
    private Informacoes informacoes;

    @PrePersist
    @PreUpdate
    private void atualizarStatusPerfil() {
        this.perfilPreenchido = this.informacoes != null;
    }

    public void setIsAdm(boolean b) {
    }
}
