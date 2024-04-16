package br.com.fiap.challenge01.model;

import br.com.fiap.challenge01.dto.AvaliacaoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity
@Data
public class Avaliacao {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Compra compra;

    @NotNull
    @Min(0)
    @Max(10)
    private Integer pontuacao;

    @Size(max = 255)
    private String comentario;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataAvaliacao;

    public Avaliacao(AvaliacaoDTO avaliacaoDTO) {
    }

    public void setIdCompra(Integer idCompra) {
    }
}
