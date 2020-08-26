package it.nike.gestnike.models.data_access;

import lombok.Data;
import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Entity
@Data
public class Contratto {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private boolean inCorso;

    private String livelloContratto;

    private Date inizioContratto;

    private Date fineContratto;

    private double retribuzioneMensileLorda;

    private double rS_bP;

    private String note;

    @OneToOne
    private TipologiaContratto tipologiaContratto;

}
