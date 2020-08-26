package it.nike.gestnike.controller.gestione_clienti;

import it.nike.gestnike.models.data_access.Cliente;
import it.nike.gestnike.models.data_access.Dipendente;
import it.nike.gestnike.services.gestione_clienti.GestioneClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nike/cliente")
public class GestioneClienteController {

    @Autowired
    private GestioneClienteService anagraficaClienteService;

    /**
     *
     * @param cliente
     * @return
     * @throws Exception
     */
    @PostMapping("/addCliente")
    public Cliente addCliente(@RequestBody Cliente cliente) throws Exception {
        try {
            return anagraficaClienteService.addCliente(cliente);
        }
        catch (Exception e) {
            throw e;
        }
    }

    /**
     *
     * @param cliente
     * @param ragSociale
     * @return
     * @throws Exception
     */
    @PostMapping("/updateCliente/{ragSociale}")
    public Cliente updateCliente(@RequestBody Cliente cliente, @PathVariable String ragSociale) throws Exception {
        return anagraficaClienteService.updateCliente(cliente, ragSociale);
    }

    /**
     *
     * @param ragSociale
     * @return
     * @throws Exception
     */
    @GetMapping("/getCliente/{ragSociale}")
    public Cliente getCliente(@PathVariable String ragSociale) throws Exception {
        return anagraficaClienteService.getCliente(ragSociale);
    }


    /**
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getAllClienti")
    public List<Cliente> getAllClienti() throws Exception {

        return anagraficaClienteService.getAllClienti();
    }

    /**
     *
     * @param ragSociale
     * @throws Exception
     */
    @GetMapping("/deleteCliente/{ragSociale}")
    public void deleteCliente (@PathVariable String ragSociale) throws Exception {
        anagraficaClienteService.deleteCliente(ragSociale);
    }

}
