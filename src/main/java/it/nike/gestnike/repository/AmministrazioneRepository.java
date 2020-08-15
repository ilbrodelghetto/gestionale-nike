package it.nike.gestnike.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.nike.gestnike.models.AppUser;

public interface AmministrazioneRepository extends MongoRepository <AppUser,String> {

	public AppUser findByEmail(String email);
	public AppUser findByEmailAndPassword(String email, String password);
	
}
