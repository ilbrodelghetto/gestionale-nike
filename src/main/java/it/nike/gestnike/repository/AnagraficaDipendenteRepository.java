package it.nike.gestnike.repository;

import it.nike.gestnike.models.AnagraficaDipendente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnagraficaDipendenteRepository extends MongoRepository<AnagraficaDipendente, String> {
}
