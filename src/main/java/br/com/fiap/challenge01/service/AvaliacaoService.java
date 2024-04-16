package br.com.fiap.challenge01.service;

import br.com.fiap.challenge01.dto.AvaliacaoDTO;
import br.com.fiap.challenge01.model.Avaliacao;
import br.com.fiap.challenge01.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;

    @Autowired
    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public List<Avaliacao> listarAvaliacoes() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao buscarAvaliacaoPorId(Integer id) {
        Optional<Avaliacao> avaliacaoOptional = avaliacaoRepository.findById(id);
        return avaliacaoOptional.orElse(null);
    }

    public void cadastrarAvaliacao(AvaliacaoDTO avaliacaoDTO) {
        Avaliacao avaliacao = new Avaliacao(avaliacaoDTO);
        avaliacaoRepository.save(avaliacao);
    }

    public void atualizarAvaliacao(Integer id, AvaliacaoDTO avaliacaoDTO) {
        Optional<Avaliacao> avaliacaoOptional = avaliacaoRepository.findById(id);
        if (avaliacaoOptional.isPresent()) {
            Avaliacao avaliacao = avaliacaoOptional.get();
            avaliacao.setIdCompra(avaliacaoDTO.getIdCompra());
            avaliacao.setPontuacao(avaliacaoDTO.getPontuacao());
            avaliacao.setComentario(avaliacaoDTO.getComentario());
            avaliacao.setDataAvaliacao(avaliacaoDTO.getDataAvaliacao());
            avaliacaoRepository.save(avaliacao);
        }
    }

    public void deletarAvaliacao(Integer id) {
        avaliacaoRepository.deleteById(id);
    }
}
