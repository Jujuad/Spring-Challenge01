package br.com.fiap.challenge01.controller;

import br.com.fiap.challenge01.dto.ServicoDTO;
import br.com.fiap.challenge01.model.Servico;
import br.com.fiap.challenge01.service.ServicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    private final ServicoService servicoService;

    @Autowired
    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @GetMapping
    public ResponseEntity<List<Servico>> listarServicos() {
        List<Servico> servicos = servicoService.listarServicos();
        return ResponseEntity.ok(servicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> buscarServicoPorId(@PathVariable Integer id) {
        Servico servico = servicoService.buscarServicoPorId(id);
        if (servico != null) {
            return ResponseEntity.ok(servico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> cadastrarServico(@Valid @RequestBody ServicoDTO servicoDTO) {
        servicoService.cadastrarServico(servicoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Serviço cadastrado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarServico(@PathVariable Integer id, @Valid @RequestBody ServicoDTO servicoDTO) {
        servicoService.atualizarServico(id, servicoDTO);
        return ResponseEntity.ok("Serviço atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarServico(@PathVariable Integer id) {
        servicoService.deletarServico(id);
        return ResponseEntity.ok("Serviço deletado com sucesso");
    }
}
