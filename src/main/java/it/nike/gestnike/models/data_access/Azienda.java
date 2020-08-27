package it.nike.gestnike.models.data_access;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@ToString(exclude = "dipendenti")
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

	@JsonBackReference
	@OneToMany(mappedBy = "azienda", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Dipendente> dipendenti;
}
