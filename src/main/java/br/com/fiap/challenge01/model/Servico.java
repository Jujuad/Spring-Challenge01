package br.com.fiap.challenge01.model;

import br.com.fiap.challenge01.dto.ServicoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 255)
    private String nome;

    @NotBlank
    @Size(max = 255)
    private String categoria;

    @NotBlank
    @Size(max = 255)
    private String descricao;

    @NotNull
    private BigDecimal preco;

    public Servico(ServicoDTO servicoDTO) {
    }
}
