package it.nike.models.dipendente;

import it.nike.models.azienda.Azienda;
import it.nike.models.contratto.Contratto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "dipendente")
@Data
public class Dipendente {

    @Id
    private String id;

    private String nome;

    private String cognome;

    private String cf;

    private String email;

    private String cellulare;

    private String domicilio;

    private String residenza;

    private String luogoNascita;

    private Date dataNascita;

    private List<Contratto> contratto;
}
