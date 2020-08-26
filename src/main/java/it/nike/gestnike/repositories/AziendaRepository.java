package it.nike.gestnike.repositories;

import it.nike.gestnike.models.data_access.Azienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AziendaRepository extends JpaRepository<Azienda, Long> {

    public Azienda findByNomeAzienda(String nomeAzienda);
}
