package it.nike.gestnike.repositories;

import it.nike.gestnike.models.data_access.Commessa;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface CommessaRepository extends JpaRepository<Commessa, Long> {
}
