package it.nike.gestnike.models.data_access;

import javax.persistence.Id;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "azienda")
@Data
public class Azienda {
	
	@Id
	private String id;

	private boolean timeMaterial;

	private String nomeAzienda;
	
	private double tariffaGiornaliera;

	private double costoLordo;

	private double margine;

	private double markup;

	private List<Cliente> clienti;

	private List<Dipendente> dipendenti;
}
