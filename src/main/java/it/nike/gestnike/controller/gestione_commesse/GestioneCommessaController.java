package it.nike.gestnike.controller.gestione_commesse;

import it.nike.gestnike.models.data_access.Commessa;
import it.nike.gestnike.models.data_access.Dipendente;
import it.nike.gestnike.services.gestione_commesse.GestioneCommessaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nike/commessa")
public class GestioneCommessaController {

    @Autowired
    private GestioneCommessaService gestioneCommessaService;

    /**
     *
     * @param commessa
     * @return
     * @throws Exception
     */
    @PostMapping("/addCommessa/{ragSociale}")
    public Commessa addCommessa(@RequestBody Commessa commessa, @PathVariable String ragSociale) throws Exception {
        return gestioneCommessaService.addCommessa(commessa, ragSociale);
    }

    /**
     *
     * @return
     */
    @GetMapping("/getAllCommesse")
    public List<Commessa> getAllCommesse() {
        return gestioneCommessaService.getAllCommesse();
    }

    /**
     *
     * @param commessa
     * @param codiceCommessa
     * @return
     * @throws Exception
     */
    @PostMapping("/aggiornaCommessa/{ragSociale}/{codiceCommessa}")
    public Commessa updateCommessa(@RequestBody Commessa commessa, @PathVariable String ragSociale, @PathVariable String codiceCommessa) throws Exception {
        return gestioneCommessaService.updateCommessa(commessa, ragSociale, codiceCommessa);
    }

    /**
     *
     * @param codiceFiscale
     * @param codiceCommessa
     * @return
     * @throws Exception
     */
    @PostMapping("/associaCommessa/{codiceFiscale}/{codiceCommessa}")
    public Dipendente associaRisorsa(@PathVariable String codiceFiscale, @PathVariable String codiceCommessa) throws Exception {
        return gestioneCommessaService.associaRisorsa(codiceFiscale, codiceCommessa);
    }

    /**
     * 
     * @param codiceFiscale
     * @return
     * @throws Exception
     */
    @GetMapping("/getCommessa/{codiceFiscale}")
    public Commessa getCommessa(@PathVariable String codiceFiscale) throws Exception {
        return gestioneCommessaService.getCommessa(codiceFiscale);
    }

    /**
     *
     * @param codiceCommessa
     * @throws Exception
     */
    @GetMapping("/deleteCommessa/{codiceFiscale}/{ragSociale}")
    public void deleteCommessa(@PathVariable String codiceCommessa, @PathVariable String ragSociale) throws Exception {
        gestioneCommessaService.deleteCommessa(codiceCommessa, ragSociale);
    }
}
