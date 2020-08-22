package it.nike.gestnike.models.data_access;


import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String ragSociale;

    private String sedeLegale;

    private String pIva;

    private String codiceFiscale;

    private String codiceInterscambio;

    private String pec;

    private List<Commessa> commesse;

    private Azienda azienda;

}
