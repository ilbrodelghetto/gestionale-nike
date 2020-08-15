package it.nike.gestnike.repositories;

import it.nike.gestnike.models.data_access.Contratto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContrattoRepository extends MongoRepository<Contratto, String> {
}
