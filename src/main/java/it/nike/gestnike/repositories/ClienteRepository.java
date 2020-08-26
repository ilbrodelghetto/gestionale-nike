package it.nike.gestnike.repositories;

import it.nike.gestnike.models.data_access.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public Cliente findByRagSociale(String ragSociale);
}
