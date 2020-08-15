package it.nike.gestnike.repository;

import it.nike.gestnike.models.Contratto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContrattoRepository extends MongoRepository<Contratto, String> {
}
