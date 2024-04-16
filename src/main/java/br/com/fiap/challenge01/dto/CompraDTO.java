package br.com.fiap.challenge01.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CompraDTO {
    private Integer id;

    @NotNull
    private Integer idServico;

    @NotNull
    private Integer idCliente;

    @NotNull
    private Date dataCompra;

    @NotNull
    private BigDecimal valor;
}
