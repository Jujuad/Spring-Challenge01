package br.com.fiap.challenge01.controller;

import br.com.fiap.challenge01.dto.AvaliacaoDTO;
import br.com.fiap.challenge01.model.Avaliacao;
import br.com.fiap.challenge01.service.AvaliacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calicoes")
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    @Autowired
    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping
    public ResponseEntity<List<Avaliacao>> listarAvaliacoes() {
        List<Avaliacao> avaliacoes = avaliacaoService.listarAvaliacoes();
        return ResponseEntity.ok(avaliacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> buscarAvaliacaoPorId(@PathVariable Integer id) {
        Avaliacao avaliacao = avaliacaoService.buscarAvaliacaoPorId(id);
        if (avaliacao != null) {
            return ResponseEntity.ok(avaliacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> cadastrarAvaliacao(@Valid @RequestBody AvaliacaoDTO avaliacaoDTO) {
        avaliacaoService.cadastrarAvaliacao(avaliacaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Avaliação cadastrada com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarAvaliacao(@PathVariable Integer id, @Valid @RequestBody AvaliacaoDTO avaliacaoDTO) {
        avaliacaoService.atualizarAvaliacao(id, avaliacaoDTO);
        return ResponseEntity.ok("Avaliação atualizada com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAvaliacao(@PathVariable Integer id) {
        avaliacaoService.deletarAvaliacao(id);
        return ResponseEntity.ok("Avaliação deletada com sucesso");
    }
}
