package it.nike.gestnike.controller;

import it.nike.gestnike.models.Cliente;
import it.nike.gestnike.services.gestione_dipendente.AnagraficaClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nike/cliente")
public class AnagraficaClienteController {

    @Autowired
    private AnagraficaClienteService anagraficaClienteService;

    /**
     *
     * @param cliente
     * @return
     * @throws Exception
     */
    @PostMapping("/addCliente")
    public Cliente addCliente(@RequestBody Cliente cliente) throws Exception {
        return anagraficaClienteService.addCliente(cliente);
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
     * @return
     * @throws Exception
     */
    @GetMapping("/getClienti")
    public List<Cliente> getAllClienti() throws Exception {

        return anagraficaClienteService.getAllClienti();
    }
}
