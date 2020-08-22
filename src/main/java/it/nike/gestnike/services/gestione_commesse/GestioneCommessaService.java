package it.nike.gestnike.services.gestione_commesse;

import it.nike.gestnike.models.data_access.Commessa;
import it.nike.gestnike.models.data_access.Dipendente;
import it.nike.gestnike.repositories.CommessaRepository;
import it.nike.gestnike.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestioneCommessaService {

    @Autowired
    private CommessaRepository commessaRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    /**
     *
     * @param commessa
     * @return
     */
    public Commessa addCommessa(Commessa commessa) throws Exception {

        try {
            return commessaRepository.save(commessa);
        }
        catch (Exception e) {
            throw new Exception("ops... qualcosa è andato storto");
        }
    }

    /**
     *
     * @return
     */
    public List<Commessa> getAllCommesse() {

        return commessaRepository.findAll();
    }

    /**
     *
     * @param commessaNew
     * @param codCommessaOld
     * @return
     * @throws Exception
     */
    public Commessa updateCommessa(Commessa commessaNew, String codCommessaOld) throws Exception {

        Optional<Commessa> commessaOld = commessaRepository.findById(codCommessaOld);
        if(commessaOld.isPresent()) {

            commessaNew.setCodiceCommessa(commessaOld.get().getCodiceCommessa());
            return commessaRepository.save(commessaNew);
        }
        else {
            throw new Exception("commessa da aggiornare non esistente");
        }
    }

    /**
     *
     * @param codiceFiscale
     * @param codiceCommessa
     * @return
     * @throws Exception
     */
    public Dipendente associaRisorsa(String codiceFiscale, String codiceCommessa) throws Exception {

        Dipendente dipendente = dipendenteRepository.findByCf(codiceFiscale);
        if(dipendente != null) {

            Optional<Commessa> commessa = commessaRepository.findById(codiceCommessa);
            if(commessa.isPresent()) {
                dipendente.setCommessa(commessa.get());
            }
            else {
                throw new Exception("commessa da associare non presente");
            }
        }
        else {
            throw new Exception("dipendente non trovato");
        }
        return dipendente;
    }

    /**
     *
     * @param codiceCommessa
     * @return
     * @throws Exception
     */
    public Commessa getCommessa(String codiceCommessa) throws Exception {

        Optional<Commessa> commessa = commessaRepository.findById(codiceCommessa);
        if(commessa.isPresent()) {

            return commessa.get();
        }
        else {
            throw new Exception("commessa non trovata");
        }
    }

    /**
     *
     * @param codiceCommessa
     * @throws Exception
     */
    public void deleteCommessa(String codiceCommessa) throws Exception {
        try {
            Optional<Commessa> commessaToDelete = commessaRepository.findById(codiceCommessa);
            if(commessaToDelete.isPresent()) {
                commessaRepository.delete(commessaToDelete.get());
            }
        }
        catch (Exception e) {
            throw new Exception("ops.. qualcosa è andato storto durante la cancellazione della commessa");
        }
    }
}
