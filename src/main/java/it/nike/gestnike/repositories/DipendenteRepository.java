package it.nike.gestnike.repositories;

import it.nike.gestnike.models.data_access.Dipendente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DipendenteRepository extends CrudRepository<Dipendente, Long> {

    public Dipendente findByCf(String cf);
}
