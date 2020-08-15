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
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

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
}
