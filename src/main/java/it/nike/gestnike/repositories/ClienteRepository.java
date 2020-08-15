package it.nike.gestnike.repositories;

import it.nike.gestnike.models.data_access.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
    public Cliente findByRagSociale(String ragSociale);
}
