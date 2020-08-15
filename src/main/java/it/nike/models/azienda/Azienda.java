package it.nike.models.azienda;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import it.nike.models.cliente.Cliente;
import it.nike.models.commessa.Commessa;
import it.nike.models.dipendente.Dipendente;

@Entity
public class Azienda {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@Column(unique = true)
	private String nomeAzienda;
	
	private double tariffaGiornaliera;
	private double costoLordo;
	private double margine;
	private double markup;
	
	@OneToMany
	private List<Dipendente> dipendente;
	
	@OneToMany
	private List<Cliente> cliente;
	
	@OneToMany
	private List<Commessa> commessa;
	
	
	
}
