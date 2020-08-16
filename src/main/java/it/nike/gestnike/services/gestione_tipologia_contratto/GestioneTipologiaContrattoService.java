package it.nike.gestnike.services.gestione_tipologia_contratto;


import it.nike.gestnike.models.data_access.TipologiaContratto;
import it.nike.gestnike.repositories.TipologiaContrattoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestioneTipologiaContrattoService {

    @Autowired
    private TipologiaContrattoRepository tipologiaContrattoRepository;

    /**
     *
     * @param tipContr
     * @return
     * @throws Exception
     */
    public TipologiaContratto addContratto (TipologiaContratto tipContr){

        return tipologiaContrattoRepository.save(tipContr);
    }

    /**
     * Recupero di tutte le tipologie contratto
     * @return
     */
    public List<TipologiaContratto> getAlltipologiaContratto(){

        return tipologiaContrattoRepository.findAll();
    }

    /**
     * 
     * @param tipologiaContrattoNew
     * @param idTipologia
     * @return
     */
    public TipologiaContratto updateTipologiaContratto(TipologiaContratto tipologiaContrattoNew, String idTipologia){

        Optional<TipologiaContratto> tipologiaOld = tipologiaContrattoRepository.findById(idTipologia);
        tipologiaOld.get().setNomeTipologia(tipologiaContrattoNew.getNomeTipologia());
        return tipologiaContrattoRepository.save(tipologiaOld.get());
    }
}
