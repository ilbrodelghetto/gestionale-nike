package it.nike.gestnike.controller.gestione_dipendenti;


import it.nike.gestnike.models.data_access.Azienda;
import it.nike.gestnike.models.data_access.Dipendente;
import it.nike.gestnike.services.gestione_dipendenti.GestioneDipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nike/dipendente")
public class GestioneDipendenteController {

    @Autowired
    private GestioneDipendenteService gestioneDipendenteService;

    /**
     *
     * @param dipendente
     * @return
     * @throws Exception
     */
    @PostMapping("/addDipendente")
    public Dipendente addDipendente(@RequestBody Dipendente dipendente) throws Exception {

        return gestioneDipendenteService.addDipendente(dipendente);
    }

    /**
     *
     * @param dipendente
     * @param codiceFiscale
     * @return
     * @throws Exception
     */
    @PostMapping("/updateDipendente/{codiceFiscale}")
    public Dipendente updateDipente(@RequestBody Dipendente dipendente, @PathVariable String codiceFiscale) throws Exception {
        System.out.println("AGGIORNAMENTO DIPENDENTE-----> " + dipendente);
        return gestioneDipendenteService.updateDipendente(dipendente, codiceFiscale);
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getDipendenti")
    public List<Dipendente> getAllDipendente() throws Exception {
        return gestioneDipendenteService.getAllDipendenti();
    }

    /**
     *
     * @param cf
     * @return
     * @throws Exception
     */
    @GetMapping("/getDipendente/{cf}")
    public Dipendente getDipendente(@PathVariable String cf) throws Exception {
        return gestioneDipendenteService.getDipendete(cf);
    }

    /**
     *
     * @param dip
     * @return
     * @throws Exception
     */
    @GetMapping("/getDipendentiFiltered")
    public List<Dipendente> getDipendentiFiltered(@RequestBody Dipendente dip) throws Exception {
        return gestioneDipendenteService.getDipendentiFiltered(dip);
    }

    /**
     *
     * @param cf
     * @throws Exception
     */
    @GetMapping("/deleteDipendente/{cf}")
    public void deleteDipendente(@PathVariable String cf) throws Exception {
        gestioneDipendenteService.deleteDipendente(cf);
    }

    @GetMapping("/getAllAziende")
    public List<Azienda> getAllAziende() {
        return gestioneDipendenteService.getAllAzienda();
    }
}

