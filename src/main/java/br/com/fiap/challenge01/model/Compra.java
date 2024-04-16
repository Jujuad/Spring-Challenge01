package br.com.fiap.challenge01.model;

import br.com.fiap.challenge01.dto.CompraDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Servico servico;

    @ManyToOne
    private Cliente cliente;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataCompra;

    @NotNull
    private BigDecimal valor;

    public Compra(CompraDTO compraDTO) {
    }

    public void setIdServico(Integer idServico) {
    }

    public void setIdCliente(Integer idCliente) {
    }
}
