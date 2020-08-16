package it.nike.gestnike.controller.gestione_tipologia_contratto;

import it.nike.gestnike.models.data_access.TipologiaContratto;
import it.nike.gestnike.services.gestione_tipologia_contratto.GestioneTipologiaContrattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nike/tipologiaContratto")
public class GestioneTipologiaController {

    @Autowired
    private GestioneTipologiaContrattoService gestioneTipologiaContrattoService;

    @PostMapping("/addTipologiaContratto")
    public TipologiaContratto addTipologiaContratto(@RequestBody TipologiaContratto tipologiaContratto) throws Exception {

        return  gestioneTipologiaContrattoService.addContratto(tipologiaContratto);
    }

    @GetMapping("/getAllTipologiaContratto")
    public List<TipologiaContratto> getAllTipologiaContratto(){

        return gestioneTipologiaContrattoService.getAllTipologiaContratto();
    }

    @PostMapping("/updateTipologiaContratto/{idTipologia}")
    public TipologiaContratto updateTipologiaContratto(@RequestBody TipologiaContratto tipologiaContratto, @PathVariable String idTipologia){

        return gestioneTipologiaContrattoService.updateTipologiaContratto(tipologiaContratto,idTipologia);
    }

}
