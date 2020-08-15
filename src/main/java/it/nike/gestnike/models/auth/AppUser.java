package it.nike.gestnike.models.auth;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Document(collection = "amministrazione")
@Data
public class AppUser {

		@Id
		private String id;
		
		private String email;

		private String password;

		private List<Ruolo> ruoli;
	}
	

