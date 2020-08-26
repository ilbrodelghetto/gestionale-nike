package it.nike.gestnike.models.data_access;

import lombok.Data;
import javax.persistence.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Entity
@Data
public class Commessa {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long codiceCommessa;

    private String descCommessa;

    private TipologiaCommessa tipologiaCommessa;

    private Date data_inizio_commessa;

    private Date data_fine_commessa;

}
