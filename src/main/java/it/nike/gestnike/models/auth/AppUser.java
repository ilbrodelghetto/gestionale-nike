package it.nike.gestnike.models.auth;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class AppUser {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private String username;

	private String email;

	private String password;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Role> roles = new HashSet<>();


	public AppUser(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public AppUser() {
	}

	public AppUser(Long id, String username, String email, String password, Set<Role> roles) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
}
	

