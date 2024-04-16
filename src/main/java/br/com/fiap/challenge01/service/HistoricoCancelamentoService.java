package br.com.fiap.challenge01.service;

import br.com.fiap.challenge01.dto.HistoricoCancelamentoDTO;
import br.com.fiap.challenge01.model.HistoricoCancelamento;
import br.com.fiap.challenge01.repository.HistoricoCancelamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricoCancelamentoService {

    private final HistoricoCancelamentoRepository historicoCancelamentoRepository;

    @Autowired
    public HistoricoCancelamentoService(HistoricoCancelamentoRepository historicoCancelamentoRepository) {
        this.historicoCancelamentoRepository = historicoCancelamentoRepository;
    }

    public List<HistoricoCancelamento> listarHistoricoCancelamentos() {
        return historicoCancelamentoRepository.findAll();
    }

    public HistoricoCancelamento buscarHistoricoCancelamentoPorId(Integer id) {
        Optional<HistoricoCancelamento> historicoCancelamentoOptional = historicoCancelamentoRepository.findById(id);
        return historicoCancelamentoOptional.orElse(null);
    }

    public void cadastrarHistoricoCancelamento(HistoricoCancelamentoDTO historicoCancelamentoDTO) {
        HistoricoCancelamento historicoCancelamento = new HistoricoCancelamento(historicoCancelamentoDTO);
        historicoCancelamentoRepository.save(historicoCancelamento);
    }

    public void atualizarHistoricoCancelamento(Integer id, HistoricoCancelamentoDTO historicoCancelamentoDTO) {
        Optional<HistoricoCancelamento> historicoCancelamentoOptional = historicoCancelamentoRepository.findById(id);
        if (historicoCancelamentoOptional.isPresent()) {
            HistoricoCancelamento historicoCancelamento = historicoCancelamentoOptional.get();
            historicoCancelamento.setIdCliente(historicoCancelamentoDTO.getIdCliente());
            historicoCancelamento.setDataCancelamento(historicoCancelamentoDTO.getDataCancelamento());
            historicoCancelamento.setMotivoCancelamento(historicoCancelamentoDTO.getMotivoCancelamento());
            historicoCancelamentoRepository.save(historicoCancelamento);
        }
    }

    public void deletarHistoricoCancelamento(Integer id) {
        historicoCancelamentoRepository.deleteById(id);
    }
}
