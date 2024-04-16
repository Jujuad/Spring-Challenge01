package br.com.fiap.challenge01.service;

import br.com.fiap.challenge01.dto.CompraDTO;
import br.com.fiap.challenge01.model.Compra;
import br.com.fiap.challenge01.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    private final CompraRepository compraRepository;

    @Autowired
    public CompraService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    public List<Compra> listarCompras() {
        return compraRepository.findAll();
    }

    public Compra buscarCompraPorId(Integer id) {
        Optional<Compra> compraOptional = compraRepository.findById(id);
        return compraOptional.orElse(null);
    }

    public void cadastrarCompra(CompraDTO compraDTO) {
        Compra compra = new Compra(compraDTO);
        compraRepository.save(compra);
    }

    public void atualizarCompra(Integer id, CompraDTO compraDTO) {
        Optional<Compra> compraOptional = compraRepository.findById(id);
        if (compraOptional.isPresent()) {
            Compra compra = compraOptional.get();
            compra.setIdServico(compraDTO.getIdServico());
            compra.setIdCliente(compraDTO.getIdCliente());
            compra.setDataCompra(compraDTO.getDataCompra());
            compra.setValor(compraDTO.getValor());
            compraRepository.save(compra);
        }
    }

    public void deletarCompra(Integer id) {
        compraRepository.deleteById(id);
    }
}
