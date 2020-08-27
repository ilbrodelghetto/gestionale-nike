package it.nike.gestnike.models.data_access;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String ragSociale;

    private String sedeLegale;

    private String piva;

    private String codiceFiscale;

    private String codiceInterscambio;

    private String pec;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Commessa> commesse;

}
