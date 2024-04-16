package br.com.fiap.challenge01.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class AvaliacaoDTO {
    private Integer id;

    @NotNull
    private Integer idCompra;

    @NotNull
    @Min(0)
    @Max(10)
    private Integer pontuacao;

    @Size(max = 255)
    private String comentario;

    @NotNull
    private Date dataAvaliacao;
}
