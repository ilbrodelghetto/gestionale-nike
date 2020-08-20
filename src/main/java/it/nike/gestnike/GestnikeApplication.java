package it.nike.gestnike;

import it.nike.gestnike.models.data_access.Azienda;
import it.nike.gestnike.repositories.AziendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class GestnikeApplication implements CommandLineRunner {

	@Autowired
	private AziendaRepository aziendaRepository;

	public static void main(String[] args) {
		SpringApplication.run(GestnikeApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {

		Optional<Azienda> nike = aziendaRepository.findById("1");
		if(!nike.isPresent()) {
			Azienda azienda = new Azienda();
			azienda.setNomeAzienda("Nike");
			azienda.setId("1");
			aziendaRepository.save(azienda);
		}

		Optional<Azienda> evolviti = aziendaRepository.findById("2");
		if(!evolviti.isPresent()) {
			Azienda azienda = new Azienda();
			azienda.setNomeAzienda("Evolviti");
			azienda.setId("2");
			aziendaRepository.save(azienda);
		}
	}
}
