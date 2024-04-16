package br.com.fiap.challenge01.service;

import br.com.fiap.challenge01.dto.ProductReviewDTO;
import br.com.fiap.challenge01.model.ProductReview;
import br.com.fiap.challenge01.repository.ProductReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductReviewService {

    private final ProductReviewRepository productReviewRepository;

    @Autowired
    public ProductReviewService(ProductReviewRepository productReviewRepository) {
        this.productReviewRepository = productReviewRepository;
    }

    public List<ProductReview> listarProductReviews() {
        return productReviewRepository.findAll();
    }

    public ProductReview buscarProductReviewPorId(Integer id) {
        Optional<ProductReview> productReviewOptional = productReviewRepository.findById(id);
        return productReviewOptional.orElse(null);
    }

    public void cadastrarProductReview(ProductReviewDTO productReviewDTO) {
        ProductReview productReview = new ProductReview(productReviewDTO);
        productReviewRepository.save(productReview);
    }

    public void atualizarProductReview(Integer id, ProductReviewDTO productReviewDTO) {
        Optional<ProductReview> productReviewOptional = productReviewRepository.findById(id);
        if (productReviewOptional.isPresent()) {
            ProductReview productReview = productReviewOptional.get();
            productReview.setIdAvaliacao(productReviewDTO.getIdAvaliacao());
            productReviewRepository.save(productReview);
        }
    }

    public void deletarProductReview(Integer id) {
        productReviewRepository.deleteById(id);
    }
}
