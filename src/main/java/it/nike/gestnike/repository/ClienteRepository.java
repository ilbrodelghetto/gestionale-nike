package it.nike.gestnike.repository;

import it.nike.gestnike.models.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
    public Cliente findByRagSociale(String ragSociale);
}
