package it.nike.gestnike.models.data_access;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    private Long codiceCommessa;

    private String descCommessa;

    private TipologiaCommessa tipologiaCommessa;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date data_inizio_commessa;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date data_fine_commessa;

}
