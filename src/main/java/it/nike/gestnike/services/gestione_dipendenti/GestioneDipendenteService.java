package it.nike.gestnike.services.gestione_dipendenti;


import it.nike.gestnike.models.data_access.Dipendente;
import it.nike.gestnike.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestioneDipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;



    /**
     *
     * @param dip Nuovo dipendente da aggiungere
     * @return dipendte nuovo aggiunto
     * @throws Exception
     */
    public Dipendente addDipendente(Dipendente dip) throws Exception {

        Dipendente dipendente = dipendenteRepository.findByCf(dip.getCf());
        if(dipendente == null) {
            return dipendenteRepository.save(dip);
        }
        else {
            throw new Exception("dipendente già esistente");
        }
    }

    /**
     * Recupero di tutti i dipendenti
     * @return
     */
    public List<Dipendente> getAllDipendenti() {

        return dipendenteRepository.findAll();
    }

    /**
     * Aggiornamento anagrafica di un dipendente
     * @param dipendente
     * @param cfDipDaAggiornare
     * @return
     */
    public Dipendente updateDipendente(Dipendente dipendente, String cfDipDaAggiornare) {

        /* Recuperiamo l'utente che deve essere aggiornato*/
        Dipendente dipendenteOld = dipendenteRepository.findByCf(cfDipDaAggiornare);

        /* settiamo l'anagrafica del dipendente aggiornato al dipende che deve essere aggiornato*/
        dipendenteOld.setAnagraficaDipendente(dipendente.getAnagraficaDipendente());

        return dipendenteRepository.save(dipendenteOld);
    }

    /**
     * Recupero di un dipendente tramite codice fiscale
     * @param codiceFiscale
     * @return
     * @throws Exception
     */
    public Dipendente getDipendete(String codiceFiscale) throws Exception {

        Dipendente dip = dipendenteRepository.findByCf(codiceFiscale);
        if(dip == null) {
            throw new Exception("dipendente non trovato");
        }
        else {
            return dip;
        }
    }
}
