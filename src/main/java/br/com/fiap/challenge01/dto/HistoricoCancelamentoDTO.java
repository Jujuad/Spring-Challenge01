package br.com.fiap.challenge01.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class HistoricoCancelamentoDTO {
    private Integer id;

    @NotNull
    private Integer idCliente;

    @NotNull
    private Date dataCancelamento;

    @NotBlank
    @Size(max = 255)
    private String motivo;

    public String getMotivoCancelamento() {
        return motivo;
    }
}
