package it.nike.gestnike.repositories.auth;

import java.util.Optional;

import it.nike.gestnike.models.auth.ERole;
import it.nike.gestnike.models.auth.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}