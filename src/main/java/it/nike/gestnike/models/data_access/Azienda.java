package it.nike.gestnike.models.data_access;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	private List<Cliente> clienti;

	private List<Dipendente> dipendenti;
}
