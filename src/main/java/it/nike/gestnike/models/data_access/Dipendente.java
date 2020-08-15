package it.nike.gestnike.models.data_access;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dipendente")
@Data
public class Dipendente {

    @Id
    private String id;

    private String cf;

    private AnagraficaDipendente anagraficaDipendente;
}
