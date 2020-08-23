package it.nike.gestnike.repositories.repositoriesImpl.implementations;

import it.nike.gestnike.models.data_access.Azienda;
import it.nike.gestnike.models.data_access.Cliente;
import it.nike.gestnike.models.data_access.Commessa;
import it.nike.gestnike.repositories.AziendaRepository;
import it.nike.gestnike.repositories.ClienteRepository;
import it.nike.gestnike.repositories.CommessaRepository;
import it.nike.gestnike.repositories.repositoriesImpl.interfaces.ClienteRepositoryInterf;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepositoryInterf<Cliente, String> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AziendaRepository aziendaRepository;

    @Autowired
    private CommessaRepository commessaRepository;

    /**
     *
     * @param cliente
     * @param nomeAzienda
     * @return
     * @throws Exception
     */
    @Override
    public Cliente save(Cliente cliente, String nomeAzienda) throws Exception {

        Azienda azienda = aziendaRepository.findByNomeAzienda(cliente.getAzienda().getNomeAzienda());
        if(azienda != null) {

            Cliente clienteNew = clienteRepository.save(cliente);
            azienda.getClienti().add(clienteNew);
            aziendaRepository.save(azienda);
            return cliente;
        }
        else {
            throw new Exception("Il salvataggio del nuovo cliente non è andato a buon fine");
        }
    }

    @Override
    public Cliente update(Cliente cliente, String ragSocialeCliente, String nomeAzienda) throws Exception {

        Azienda azienda = aziendaRepository.findByNomeAzienda(cliente.getAzienda().getNomeAzienda());
        if(azienda != null) {

            Cliente clienteold = clienteRepository.findByRagSociale(ragSocialeCliente);
            cliente.setId(clienteold.getId());
            cliente.setCommesse(updateAllCommesse(cliente, cliente.getCommesse()));
            azienda.getClienti().remove(clienteold);
            azienda.getClienti().add(cliente);
            cliente.setAzienda(aziendaRepository.save(azienda));
            return clienteRepository.save(cliente);
        }
        else {
            throw new Exception("L'aggiornamento del cliente non è andato a buon fine");
        }
    }

    @Override
    public void delete(Cliente cliente, String nomeAzienda) throws Exception {

        Azienda azienda = aziendaRepository.findByNomeAzienda(cliente.getAzienda().getNomeAzienda());
        if (azienda != null) {

            azienda.getClienti().remove(cliente);
            aziendaRepository.save(azienda);
        } else {

        }
    }
    /**
     *
     * @param cliente
     * @param commesse
     * @return
     */
    private List<Commessa> updateAllCommesse(Cliente cliente, List<Commessa> commesse) {

        for(Commessa commessa: commesse) {
            commessa.setCliente(cliente);
        }
        return commessaRepository.saveAll(commesse);
    }
}
