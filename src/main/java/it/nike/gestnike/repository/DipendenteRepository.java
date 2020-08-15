package it.nike.gestnike.repository;

import it.nike.gestnike.models.Dipendente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DipendenteRepository extends MongoRepository <Dipendente, String> {

    public Dipendente findByCf(String cf);
}
