package it.nike.gestnike.models.data_access;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class TipologiaContratto {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String nomeTipologia;

}
