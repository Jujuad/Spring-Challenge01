package br.com.fiap.challenge01.controller;

import br.com.fiap.challenge01.dto.HistoricoCancelamentoDTO;
import br.com.fiap.challenge01.model.HistoricoCancelamento;
import br.com.fiap.challenge01.service.HistoricoCancelamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historicoCancelamentos")
public class HistoricoCancelamentoController {

    private final HistoricoCancelamentoService historicoCancelamentoService;

    @Autowired
    public HistoricoCancelamentoController(HistoricoCancelamentoService historicoCancelamentoService) {
        this.historicoCancelamentoService = historicoCancelamentoService;
    }

    @GetMapping
    public ResponseEntity<List<HistoricoCancelamento>> listarHistoricoCancelamentos() {
        List<HistoricoCancelamento> historicoCancelamentos = historicoCancelamentoService.listarHistoricoCancelamentos();
        return ResponseEntity.ok(historicoCancelamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoricoCancelamento> buscarHistoricoCancelamentoPorId(@PathVariable Integer id) {
        HistoricoCancelamento historicoCancelamento = historicoCancelamentoService.buscarHistoricoCancelamentoPorId(id);
        if (historicoCancelamento != null) {
            return ResponseEntity.ok(historicoCancelamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> cadastrarHistoricoCancelamento(@Valid @RequestBody HistoricoCancelamentoDTO historicoCancelamentoDTO) {
        historicoCancelamentoService.cadastrarHistoricoCancelamento(historicoCancelamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Histórico de cancelamento cadastrado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarHistoricoCancelamento(@PathVariable Integer id, @Valid @RequestBody HistoricoCancelamentoDTO historicoCancelamentoDTO) {
        historicoCancelamentoService.atualizarHistoricoCancelamento(id, historicoCancelamentoDTO);
        return ResponseEntity.ok("Histórico de cancelamento atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarHistoricoCancelamento(@PathVariable Integer id) {
        historicoCancelamentoService.deletarHistoricoCancelamento(id);
        return ResponseEntity.ok("Histórico de cancelamento deletado com sucesso");
    }
}
