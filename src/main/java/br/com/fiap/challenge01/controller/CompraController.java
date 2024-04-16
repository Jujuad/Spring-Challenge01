package br.com.fiap.challenge01.controller;

import br.com.fiap.challenge01.dto.CompraDTO;
import br.com.fiap.challenge01.model.Compra;
import br.com.fiap.challenge01.service.CompraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private final CompraService compraService;

    @Autowired
    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @GetMapping
    public ResponseEntity<List<Compra>> listarCompras() {
        List<Compra> compras = compraService.listarCompras();
        return ResponseEntity.ok(compras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> buscarCompraPorId(@PathVariable Integer id) {
        Compra compra = compraService.buscarCompraPorId(id);
        if (compra != null) {
            return ResponseEntity.ok(compra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> cadastrarCompra(@Valid @RequestBody CompraDTO compraDTO) {
        compraService.cadastrarCompra(compraDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Compra cadastrada com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarCompra(@PathVariable Integer id, @Valid @RequestBody CompraDTO compraDTO) {
        compraService.atualizarCompra(id, compraDTO);
        return ResponseEntity.ok("Compra atualizada com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCompra(@PathVariable Integer id) {
        compraService.deletarCompra(id);
        return ResponseEntity.ok("Compra deletada com sucesso");
    }
}
