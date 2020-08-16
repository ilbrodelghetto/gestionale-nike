package it.nike.gestnike.models.data_access;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "tipologiaContratto")
@Data
public class TipologiaContratto {

    @Id
    private String id;

    private String nomeTipologia;

}
