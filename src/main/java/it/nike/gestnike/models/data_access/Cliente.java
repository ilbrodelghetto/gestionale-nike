package it.nike.gestnike.models.data_access;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "cliente")
@Data
public class Cliente {

    @Id
    private String id;

    private String ragSociale;

    private String sedeLegale;

    private String pIva;

    private String codiceFiscale;

    private String codiceInterscambio;

    private String pec;

    private List<Commessa> commesse;
    
    private Azienda azienda;


}
