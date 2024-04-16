package br.com.fiap.challenge01.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class ProductReviewDTO {
    private Integer id;

    @NotNull
    private Integer idAvaliacao;
}
