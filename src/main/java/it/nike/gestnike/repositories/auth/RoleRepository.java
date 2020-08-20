package it.nike.gestnike.repositories.auth;

import java.util.Optional;

import it.nike.gestnike.models.auth.ERole;
import it.nike.gestnike.models.auth.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}