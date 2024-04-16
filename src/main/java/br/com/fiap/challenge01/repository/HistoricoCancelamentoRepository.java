package br.com.fiap.challenge01.repository;

import br.com.fiap.challenge01.model.HistoricoCancelamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoCancelamentoRepository extends JpaRepository<HistoricoCancelamento, Integer> {
}
