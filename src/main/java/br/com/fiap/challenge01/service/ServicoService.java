package br.com.fiap.challenge01.service;

import br.com.fiap.challenge01.dto.ServicoDTO;
import br.com.fiap.challenge01.model.Servico;
import br.com.fiap.challenge01.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;

    @Autowired
    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public List<Servico> listarServicos() {
        return servicoRepository.findAll();
    }

    public Servico buscarServicoPorId(Integer id) {
        Optional<Servico> servicoOptional = servicoRepository.findById(id);
        return servicoOptional.orElse(null);
    }

    public void cadastrarServico(ServicoDTO servicoDTO) {
        Servico servico = new Servico(servicoDTO);
        servicoRepository.save(servico);
    }

    public void atualizarServico(Integer id, ServicoDTO servicoDTO) {
        Optional<Servico> servicoOptional = servicoRepository.findById(id);
        if (servicoOptional.isPresent()) {
            Servico servico = servicoOptional.get();
            servico.setNome(servicoDTO.getNome());
            servico.setCategoria(servicoDTO.getCategoria());
            servico.setDescricao(servicoDTO.getDescricao());
            servico.setPreco(servicoDTO.getPreco());
            servicoRepository.save(servico);
        }
    }

    public void deletarServico(Integer id) {
        servicoRepository.deleteById(id);
    }
}
