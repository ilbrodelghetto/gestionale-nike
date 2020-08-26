package it.nike.gestnike.services.gestione_clienti;

import it.nike.gestnike.models.data_access.Azienda;
import it.nike.gestnike.models.data_access.Cliente;
import it.nike.gestnike.models.data_access.Dipendente;
import it.nike.gestnike.repositories.AziendaRepository;
import it.nike.gestnike.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class GestioneClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AziendaRepository aziendaRepository;
    /**
     *
     * @param ragSociale
     * @return
     * @throws Exception
     */
    public Cliente getCliente(String ragSociale) throws Exception {

        Cliente cli = clienteRepository.findByRagSociale(ragSociale);
        if(cli == null) {
            throw new Exception("cliente non trovato");
        }
        else {
            return cli;
        }
    }

    /**
     *
     * @return
     */
    public List<Cliente> getAllClienti(){

        return (List<Cliente>) clienteRepository.findAll();
    }

    /**
     *
     * @param cli Nuovo cliente da aggiungere
     * @return cliente nuovo aggiunto
     * @throws Exception
     */
    public Cliente addCliente(Cliente cli) throws Exception {

        Cliente cliente = clienteRepository.findByRagSociale(cli.getRagSociale());
        if(cliente == null){
                cliente = clienteRepository.save(cli);
            }
            else {
                throw new Exception("azienda non trovata");
            }
        return null;
    }

    /**
     * Aggiornamento anagrafica di un cliente
     * @param cliente
     * @param ragSocialeDaAggiornare
     * @return
     */
    public Cliente updateCliente(Cliente cliente, String ragSocialeDaAggiornare) throws Exception {

        Cliente clienteOld = clienteRepository.findByRagSociale(ragSocialeDaAggiornare);
        if(clienteOld != null) {
            cliente.setId(clienteOld.getId());
            cliente = clienteRepository.save(cliente);
            return cliente;
        }
            else {
                throw new Exception("cliente da aggiornare non trovato");
            }
    }

    /**
     * 
     * @param ragSociale
     * @throws Exception
     */
    public void deleteCliente(String ragSociale) throws Exception {

        try{
            Cliente clienteToDelete = clienteRepository.findByRagSociale(ragSociale);
            if(clienteToDelete != null){
                clienteRepository.delete(clienteToDelete);
            }
        }
        catch (Exception e) {
            throw new Exception("Il cliente non è stato rimosso");
        }

    }


}
