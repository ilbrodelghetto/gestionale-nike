package it.nike.gestnike.models.data_access;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import javax.persistence.*;

@Entity
@Data
public class AnagraficaDipendente {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String nome;

    private String cognome;

    private String email;

    private String cellulare;

    private String domicilio;

    private String residenza;

    private String luogoNascita;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dataNascita;

}
