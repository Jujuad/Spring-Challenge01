package br.com.fiap.challenge01.model;

import br.com.fiap.challenge01.dto.HistoricoCancelamentoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class HistoricoCancelamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Cliente cliente;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataCancelamento;

    @NotBlank
    @Size(max = 255)
    private String motivo;

    public HistoricoCancelamento(HistoricoCancelamentoDTO historicoCancelamentoDTO) {
    }

    public void setIdCliente(Integer idCliente) {
    }

    public void setMotivoCancelamento(Object motivoCancelamento) {
    }
}
