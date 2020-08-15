package it.nike.gestnike.repositories;

import it.nike.gestnike.models.data_access.AnagraficaDipendente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnagraficaDipendenteRepository extends MongoRepository<AnagraficaDipendente, String> {
}
