package com.example.projetosea.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Informacoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;

    @ElementCollection
    private List<String> emails;

    @ElementCollection
    private List<String> telefones;

    private String cep;

    private String endereco;

    private String numero;

    private String complemento;

    private String bairro;
}
