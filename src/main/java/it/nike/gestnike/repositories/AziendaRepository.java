package it.nike.gestnike.repositories;

import it.nike.gestnike.models.data_access.Azienda;
import org.springframework.data.repository.CrudRepository;

public interface AziendaRepository extends CrudRepository<Azienda, Long> {

    public Azienda findByNomeAzienda(String nomeAzienda);
}
