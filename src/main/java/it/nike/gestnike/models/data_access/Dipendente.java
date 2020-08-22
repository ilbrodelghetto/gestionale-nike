package it.nike.gestnike.models.data_access;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

@Entity
@Data
public class Dipendente {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String cf;

    private List<Contratto> contratto;

    private Commessa commessa;

    private AnagraficaDipendente anagraficaDipendente;

    private Azienda azienda;
}
