package it.nike.gestnike.models.auth;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document(collection = "amministrazione")
@Data
public class AppUser {

	@Id
	private String id;

	private String username;

	private String email;

	private String password;

	private Set<Role> roles = new HashSet<>();


	public AppUser(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public AppUser() {
	}

	public AppUser(String id, String username, String email, String password, Set<Role> roles) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
}
	

