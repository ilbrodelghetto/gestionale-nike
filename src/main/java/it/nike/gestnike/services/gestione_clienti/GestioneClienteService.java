package it.nike.gestnike.services.gestione_clienti;

import it.nike.gestnike.models.data_access.Cliente;
import it.nike.gestnike.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestioneClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClienti(){

        return clienteRepository.findAll();
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
            return clienteRepository.save(cli);
        }
        else{
            throw new Exception ("Cliente eistente");
        }
    }

    /**
     * Aggiornamento anagrafica di un dipendente
     * @param cliente
     * @param ragSocialeDaAggiornare
     * @return
     */
    public Cliente updateCliente(Cliente cliente, String ragSocialeDaAggiornare){

        Cliente clienteOld = clienteRepository.findByRagSociale(ragSocialeDaAggiornare);
        cliente.setId(clienteOld.getId());
        return clienteRepository.save(cliente);
    }


}
