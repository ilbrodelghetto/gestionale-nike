package it.nike.gestnike.services.gestione_dipendenti;


import it.nike.gestnike.models.data_access.Azienda;
import it.nike.gestnike.models.data_access.Dipendente;
import it.nike.gestnike.repositories.AziendaRepository;
import it.nike.gestnike.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestioneDipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private AziendaRepository aziendaRepository;

    /**
     *
     * @param dip Nuovo dipendente da aggiungere
     * @return dipendte nuovo aggiunto
     * @throws Exception
     */
    public Dipendente addDipendente(Dipendente dip) throws Exception {

        Dipendente dipendente = dipendenteRepository.findByCf(dip.getCf());
        if(dipendente == null) {
            Azienda azienda = aziendaRepository.findByNomeAzienda(dip.getAzienda().getNomeAzienda());
            System.out.println("azienda da aggiornare al dipendente--------->" + azienda);
            if(azienda != null) {
                dip.setAzienda(azienda);
                dip = dipendenteRepository.save(dip);
                return dip;
            }
        }
        else {
            throw  new Exception("Dipendente gia esistente");
        }
        return null;
    }

    /**
     * Recupero di tutti i dipendenti
     * @return
     */
    public List<Dipendente> getAllDipendenti() {

        return (List<Dipendente>) dipendenteRepository.findAll();
    }

    /**
     * Aggiornamento anagrafica di un dipendente
     * @param dip
     * @param cfDipDaAggiornare
     * @return
     */
    public Dipendente updateDipendente(Dipendente dip, String cfDipDaAggiornare) throws Exception {

        /* Recuperiamo l'utente che deve essere aggiornato*/
        Dipendente dipendenteOld = dipendenteRepository.findByCf(cfDipDaAggiornare);

        if(dipendenteOld != null) {

            /* settiamo l'anagrafica del dipendente aggiornato al dipende che deve essere aggiornato*/
            Azienda azienda = aziendaRepository.findByNomeAzienda(dip.getAzienda().getNomeAzienda());
            System.out.println("azienda da aggiornare al dipendente--------->" + azienda);
            if(azienda != null) {

                dipendenteOld.setAzienda(azienda);
                dipendenteOld.setAnagraficaDipendente(dip.getAnagraficaDipendente());
                dip = dipendenteRepository.save(dipendenteOld);
                return dip;
            }
        }
        else {
            throw new Exception("dipendente da aggiornare non trovato");
        }
        return null;
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


    /**
     *
     * @param cfDipendente
     * @throws Exception
     */
    public void deleteDipendente(String cfDipendente) throws Exception {
        try {
            Dipendente dipendeteToDelete = dipendenteRepository.findByCf(cfDipendente);
            System.out.println("DELETE DIPENDENTE------->" + dipendeteToDelete);
            if (dipendeteToDelete != null) {

                    dipendenteRepository.delete(dipendeteToDelete);
                }
                else {
                    throw new Exception("azienda non trovata");
                }
            }
        catch (Exception e) {
            throw new Exception("azienda non trovata");
        }
    }

    /**
     *
     * @return
     */
    public List<Azienda> getAllAzienda() {

        return (List<Azienda>) aziendaRepository.findAll();
    }
}
