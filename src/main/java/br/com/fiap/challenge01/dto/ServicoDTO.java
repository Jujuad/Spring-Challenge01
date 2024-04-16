package br.com.fiap.challenge01.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ServicoDTO {
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
}
