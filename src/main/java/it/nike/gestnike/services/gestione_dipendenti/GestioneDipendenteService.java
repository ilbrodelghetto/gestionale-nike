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
        System.out.println("INSERIMENTO DIPENDENTE--------------___> " + dip);

        if(dipendente == null) {
            Azienda azienda = aziendaRepository.findByNomeAzienda(dip.getAzienda().getNomeAzienda());
            System.out.println("azienda da aggiornare al dipendente--------->" + azienda);
            if(azienda != null) {

                dip.setAzienda(azienda);
                dip.setCommessa(null);
                dip = dipendenteRepository.save(dip);
                aziendaRepository.save(azienda);
                return dip;
            }
            else {
                dip.setAzienda(null);
                dip.setCommessa(null);
                dip = dipendenteRepository.save(dip);
                return dip;
            }
        }
        else {
            throw  new Exception("Dipendente gia esistente");
        }
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
        System.out.println("azienda da aggiornare al dipendente--------->" + dip);

        if(dipendenteOld != null) {

            /* settiamo l'anagrafica del dipendente aggiornato al dipende che deve essere aggiornato*/
            Azienda azienda = aziendaRepository.findByNomeAzienda(dip.getAzienda().getNomeAzienda());

            if(azienda != null) {

//                if(!azienda.getNomeAzienda().equals(dipendenteOld.getAzienda().getNomeAzienda())) {
//
//                    Azienda aziendaOld = aziendaRepository.findByNomeAzienda(dipendenteOld.getAzienda().getNomeAzienda());
//                    aziendaOld.getDipendenti().remove(dipendenteOld);
//                    aziendaRepository.save(aziendaOld);
//                    dipendenteOld.setAnagraficaDipendente(dip.getAnagraficaDipendente());
//                    azienda.getDipendenti().add(dipendenteOld);
//                    aziendaRepository.save(azienda);
//                }
//                else {

                    //azienda.getDipendenti().remove(dipendenteOld);
                    dipendenteOld.setAzienda(azienda);
                    dipendenteOld.setAnagraficaDipendente(dip.getAnagraficaDipendente());
                    dip = dipendenteRepository.save(dipendenteOld);
                    //azienda.getDipendenti().add(dip);
                    //aziendaRepository.save(azienda);
                    return dip;
  //              }
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
                Azienda azienda = aziendaRepository.findByNomeAzienda(dipendeteToDelete.getAzienda().getNomeAzienda());
                azienda.getDipendenti().remove(dipendeteToDelete);
                aziendaRepository.save(dipendeteToDelete.getAzienda());
                dipendenteRepository.delete(dipendeteToDelete);
            }
            else {
                throw new Exception("La cancellazione non è andata a buon fine");
            }
        }
        catch (Exception e) {
            throw e;
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
