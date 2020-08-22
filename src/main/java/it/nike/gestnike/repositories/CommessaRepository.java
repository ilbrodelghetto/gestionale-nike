package it.nike.gestnike.repositories;

import it.nike.gestnike.models.data_access.Commessa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommessaRepository extends MongoRepository<Commessa, String> {
}
