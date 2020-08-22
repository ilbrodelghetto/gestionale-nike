package it.nike.gestnike.controller.gestione_tipologia_contratto;

import it.nike.gestnike.models.data_access.Contratto;
import it.nike.gestnike.models.data_access.Dipendente;
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

    @GetMapping("/getContratto/{idContratto}")
    public Contratto getContratto(@PathVariable String idContratto) throws Exception {
        return gestioneTipologiaContrattoService.getContratto(idContratto);
    }

    @PostMapping("/addTipologiaContratto")
    public TipologiaContratto addTipologiaContratto(@RequestBody TipologiaContratto tipologiaContratto) throws Exception {

        return  gestioneTipologiaContrattoService.addTipologiaContratto(tipologiaContratto);
    }

    @PostMapping("/addContratto")
    public Contratto addContratto(@RequestBody Contratto contr) throws Exception {

        return  gestioneTipologiaContrattoService.addContratto(contr);
    }

    @GetMapping("/deleteContratto")
    public void deleteContratto(@PathVariable String idContratto) throws Exception{

        gestioneTipologiaContrattoService.deleteContratto(idContratto);
    }

    @GetMapping("/getAllContratto")
    public List<Contratto> getAllContratto(){
        
        return gestioneTipologiaContrattoService.getAllContratto();
    }

    @GetMapping("/getAllTipologiaContratto")
    public List<TipologiaContratto> getAllTipologiaContratto(){

        return gestioneTipologiaContrattoService.getAllTipologiaContratto();
    }

    @PostMapping("/updateTipologiaContratto/{idTipologia}")
    public TipologiaContratto updateTipologiaContratto(@RequestBody TipologiaContratto tipologiaContratto, @PathVariable String idTipologia){

        return gestioneTipologiaContrattoService.updateTipologiaContratto(tipologiaContratto,idTipologia);
    }

    @GetMapping("/deleteTipologiaContratto/{idTipologia}")
    public void deleteTipologia(@PathVariable String idTipologia) throws Exception {

        gestioneTipologiaContrattoService.deleteTipologia(idTipologia);
    }

}
