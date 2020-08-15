package it.nike.gestnike.models;

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

    private String cf;

    private AnagraficaDipendente anagraficaDipendente;
}
