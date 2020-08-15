package it.nike.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.nike.models.amministrazione.Amministrazione;

public interface AmministrazioneRepository extends MongoRepository <Amministrazione,String> {

	public Amministrazione findByEmail(String email);
	public Amministrazione findByEmailAndPassword(String email, String password);
	
}
