package br.com.fiap.challenge01.model;

import br.com.fiap.challenge01.dto.ProductReviewDTO;
import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
public class ProductReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Avaliacao avaliacao;

    public ProductReview(ProductReviewDTO productReviewDTO) {
    }

    public void setIdAvaliacao(Integer idAvaliacao) {
    }
}
