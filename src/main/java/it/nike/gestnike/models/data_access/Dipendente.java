package it.nike.gestnike.models.data_access;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Dipendente {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String cf;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Contratto> contratto;

    @ManyToOne(fetch = FetchType.EAGER)
    private Commessa commessa;

    @OneToOne(cascade = CascadeType.ALL)
    private AnagraficaDipendente anagraficaDipendente;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    private Azienda azienda;

}
