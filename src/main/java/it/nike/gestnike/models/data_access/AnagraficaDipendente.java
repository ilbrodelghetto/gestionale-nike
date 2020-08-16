package it.nike.gestnike.models.data_access;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "anagrafica-dipendente")
@Data
public class AnagraficaDipendente {

    @Id
    private String id;

    private String nome;

    private String cognome;

    private String email;

    private String cellulare;

    private String domicilio;

    private String residenza;

    private String luogoNascita;

    private Date dataNascita;

    private List<Contratto> contratto;

    private Commessa commessa;
}
