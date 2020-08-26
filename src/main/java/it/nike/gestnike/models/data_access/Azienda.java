package it.nike.gestnike.models.data_access;

import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Data
public class Azienda {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private boolean timeMaterial;

	private String nomeAzienda;
	
	private double tariffaGiornaliera;

	private double costoLordo;

	private double margine;

	private double markup;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Cliente> clienti;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Dipendente> dipendenti;
}
