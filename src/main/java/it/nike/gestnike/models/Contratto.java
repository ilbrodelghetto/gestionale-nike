package it.nike.gestnike.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "contratto")
@Data
public class Contratto {

    @Id
    private String id;

    private boolean inCorso;

    private String livelloContratto;

    private Date inizioContratto;

    private Date fineContratto;

    private double retribuzioneMensileLorda;

    private double rS_bP;

    private String note;

    private Azienda azienda;

}
