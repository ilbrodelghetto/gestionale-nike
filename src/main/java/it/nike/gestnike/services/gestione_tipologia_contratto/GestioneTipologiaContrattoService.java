package it.nike.gestnike.services.gestione_tipologia_contratto;


import it.nike.gestnike.models.data_access.Cliente;
import it.nike.gestnike.models.data_access.Contratto;
import it.nike.gestnike.models.data_access.TipologiaContratto;
import it.nike.gestnike.repositories.ContrattoRepository;
import it.nike.gestnike.repositories.TipologiaContrattoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestioneTipologiaContrattoService {

    @Autowired
    private TipologiaContrattoRepository tipologiaContrattoRepository;
    @Autowired
    private ContrattoRepository contrattoRepository;

    /**
     *
     * @param idContratto
     * @return
     * @throws Exception
     */
    public Contratto getContratto(String idContratto) throws Exception {

        Optional<Contratto> contr = contrattoRepository.findById(idContratto);
        if(!contr.isPresent()) {
            throw new Exception("contratto non trovato");
        }
        else {
            return contr.get();
        }
    }

    /**
     *
     * @return
     */
    public List<Contratto> getAllContratto () {

        return contrattoRepository.findAll();
    }

    /**
     * @param contr
     * @return
     */
    public Contratto addContratto(Contratto contr) {

        return contrattoRepository.save(contr);
    }

    /**
     * 
     * @param contratto
     * @param idContratto
     * @return
     */
    public Contratto updateContratto(Contratto contratto, String idContratto){

        Optional<TipologiaContratto> contrattoOld = tipologiaContrattoRepository.findById(idContratto);
        contratto.setId(contrattoOld.get().getId());
        return contrattoRepository.save(contratto);
    }

    /**
     *
     * @param idContratto
     * @throws Exception
     */
    public void deleteContratto(String idContratto) throws Exception {

        try {
            Optional<Contratto> contrattoDaEliminare = contrattoRepository.findById(idContratto);
            if (contrattoDaEliminare.isPresent()) {
                contrattoRepository.delete(contrattoDaEliminare.get());
            }
        } catch (Exception e) {
            throw new Exception("La tipologia non è stata rimossa");
        }
    }

        /**
         *
         * @param tipContr
         * @return
         * @throws Exception
         */

        public TipologiaContratto addTipologiaContratto (TipologiaContratto tipContr){

            return tipologiaContrattoRepository.save(tipContr);
        }

        /**
         * Recupero di tutte le tipologie contratto
         * @return
         */
        public List<TipologiaContratto> getAllTipologiaContratto () {

            return tipologiaContrattoRepository.findAll();
        }


        /**
         *
         * @param tipologiaContrattoNew
         * @param idTipologia
         * @return
         */
        public TipologiaContratto updateTipologiaContratto (TipologiaContratto tipologiaContrattoNew, String idTipologia)
        {

            Optional<TipologiaContratto> tipologiaOld = tipologiaContrattoRepository.findById(idTipologia);
            tipologiaOld.get().setNomeTipologia(tipologiaContrattoNew.getNomeTipologia());
            return tipologiaContrattoRepository.save(tipologiaOld.get());
        }

        /**
         *
         * @param idTipologia
         * @throws Exception
         */
        public void deleteTipologia (String idTipologia)throws Exception {

            try {
                Optional<TipologiaContratto> tipogiaDaEliminare = tipologiaContrattoRepository.findById(idTipologia);
                if (tipogiaDaEliminare.isPresent()) {
                    tipologiaContrattoRepository.delete(tipogiaDaEliminare.get());
                }
            } catch (Exception e) {
                throw new Exception("La tipologia non è stata rimossa");
            }

        }
    }

