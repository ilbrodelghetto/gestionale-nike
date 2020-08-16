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
    public TipologiaContratto addContratto (TipologiaContratto tipContr) throws Exception {

        Optional<TipologiaContratto> tipologiaContratto = tipologiaContrattoRepository.findById(tipContr.getId());
        if(tipologiaContratto.isPresent()) {
            return tipologiaContrattoRepository.save(tipologiaContratto.get());
        }
        else {
            throw new Exception ("Tipologia contratto esistente");
        }
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
     * @param tipologiaContratto
     * @param tipologiaDaAggiornare
     * @return
     */
    public TipologiaContratto updateTipologiaContratto(TipologiaContratto tipologiaContratto,String tipologiaDaAggiornare){

        Optional<TipologiaContratto> tipologiaOld = tipologiaContrattoRepository.findById(tipologiaDaAggiornare);

        tipologiaOld.get().setNomeTipologia(tipologiaContratto.getNomeTipologia());

        return tipologiaContrattoRepository.save(tipologiaOld.get());

    }
}
