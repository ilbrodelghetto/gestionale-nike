package it.nike.gestnike.repositories;

import it.nike.gestnike.models.data_access.Azienda;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AziendaRepository extends MongoRepository<Azienda, String> {

}
