package it.nike.gestnike.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "commessa")
@Data
public class Commessa {

    @Id
    private String codiceCommessa;

    private String descCommessa;

    private TipologiaCommessa tipologiaCommessa;

    private Date data_inizio_commessa;

    private Date data_fine_commessa;

}
