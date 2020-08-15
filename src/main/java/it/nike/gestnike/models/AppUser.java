package it.nike.gestnike.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	

