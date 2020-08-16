package it.nike.gestnike.repositories;

import it.nike.gestnike.models.data_access.TipologiaContratto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TipologiaContrattoRepository extends MongoRepository<TipologiaContratto, String> {


}
