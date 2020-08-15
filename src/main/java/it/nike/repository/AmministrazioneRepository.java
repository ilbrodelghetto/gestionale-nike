package it.nike.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.nike.models.amministrazione.AppUser;

public interface AmministrazioneRepository extends MongoRepository <AppUser,String> {

	public AppUser findByEmail(String email);
	public AppUser findByEmailAndPassword(String email, String password);
	
}
