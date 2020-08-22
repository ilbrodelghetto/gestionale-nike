package it.nike.gestnike.repositories;

import it.nike.gestnike.models.data_access.Commessa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommessaRepository extends CrudRepository<Commessa, Long> {
}
