package it.nike.gestnike;

import it.nike.gestnike.models.auth.AppUser;
import it.nike.gestnike.models.auth.ERole;
import it.nike.gestnike.models.auth.Role;
import it.nike.gestnike.models.data_access.Azienda;
import it.nike.gestnike.repositories.AziendaRepository;
import it.nike.gestnike.repositories.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class GestnikeApplication implements CommandLineRunner {

	@Autowired
	private AziendaRepository aziendaRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(GestnikeApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {

//		Optional<Azienda> nike = aziendaRepository.findById("1");
//		if(!nike.isPresent()) {
//			Azienda azienda = new Azienda();
//			azienda.setNomeAzienda("Nike");
//			azienda.setId("1");
//			aziendaRepository.save(azienda);
//		}
//
//		Optional<Azienda> evolviti = aziendaRepository.findById("2");
//		if(!evolviti.isPresent()) {
//			Azienda azienda = new Azienda();
//			azienda.setNomeAzienda("Evolviti");
//			azienda.setId("2");
//			aziendaRepository.save(azienda);
//		}
		Optional<AppUser> userOpt = userRepository.findByUsername("nike");
		if(!userOpt.isPresent()) {
			AppUser user = new AppUser();
			user.setId("2222222");
			user.setEmail("jelassi.hass@nikeconsulting.com");
			user.setUsername("nike");
			user.setPassword(encoder.encode("nike"));
			Set<Role> roles = new HashSet<>();
			roles.add(new Role(ERole.ADMIN));
			roles.add(new Role(ERole.USER));
			user.setRoles(roles);
			userRepository.save(user);
			System.out.println("AGGIUNTO ADMIN USER");
		}
	}
}
