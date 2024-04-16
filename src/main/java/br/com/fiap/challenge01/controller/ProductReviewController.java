package br.com.fiap.challenge01.controller;

import br.com.fiap.challenge01.dto.ProductReviewDTO;
import br.com.fiap.challenge01.model.ProductReview;
import br.com.fiap.challenge01.service.ProductReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productReviews")
public class ProductReviewController {

    private final ProductReviewService productReviewService;

    @Autowired
    public ProductReviewController(ProductReviewService productReviewService) {
        this.productReviewService = productReviewService;
    }

    @GetMapping
    public ResponseEntity<List<ProductReview>> listarProductReviews() {
        List<ProductReview> productReviews = productReviewService.listarProductReviews();
        return ResponseEntity.ok(productReviews);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductReview> buscarProductReviewPorId(@PathVariable Integer id) {
        ProductReview productReview = productReviewService.buscarProductReviewPorId(id);
        if (productReview != null) {
            return ResponseEntity.ok(productReview);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> cadastrarProductReview(@Valid @RequestBody ProductReviewDTO productReviewDTO) {
        productReviewService.cadastrarProductReview(productReviewDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("ProductReview cadastrado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarProductReview(@PathVariable Integer id, @Valid @RequestBody ProductReviewDTO productReviewDTO) {
        productReviewService.atualizarProductReview(id, productReviewDTO);
        return ResponseEntity.ok("ProductReview atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProductReview(@PathVariable Integer id) {
        productReviewService.deletarProductReview(id);
        return ResponseEntity.ok("ProductReview deletado com sucesso");
    }
}
