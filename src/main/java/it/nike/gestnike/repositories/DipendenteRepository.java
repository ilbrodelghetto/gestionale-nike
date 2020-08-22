package it.nike.gestnike.repositories;

import it.nike.gestnike.models.data_access.Dipendente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DipendenteRepository extends MongoRepository <Dipendente, String> {

    public Dipendente findByCf(String cf);
}
