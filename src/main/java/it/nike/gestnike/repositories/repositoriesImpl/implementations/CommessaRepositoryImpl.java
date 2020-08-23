package it.nike.gestnike.repositories.repositoriesImpl.implementations;

import it.nike.gestnike.models.data_access.Azienda;
import it.nike.gestnike.models.data_access.Cliente;
import it.nike.gestnike.models.data_access.Commessa;
import it.nike.gestnike.repositories.AziendaRepository;
import it.nike.gestnike.repositories.ClienteRepository;
import it.nike.gestnike.repositories.CommessaRepository;
import it.nike.gestnike.repositories.repositoriesImpl.interfaces.CommessaRepositoryInterf;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CommessaRepositoryImpl implements CommessaRepositoryInterf<Commessa, String> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AziendaRepository aziendaRepository;

    @Autowired
    private CommessaRepository commessaRepository;

    /**
     *
     * @param commessa
     * @param ragSocialeCliente
     * @return
     * @throws Exception
     */
    @Override
    public Commessa save(Commessa commessa, String ragSocialeCliente) throws Exception {

        Cliente cliente = clienteRepository.findByRagSociale(ragSocialeCliente);
        if(cliente != null) {

            Azienda azienda = aziendaRepository.findByNomeAzienda(cliente.getAzienda().getNomeAzienda());
            if(azienda != null) {
                cliente.getCommesse().add(commessaRepository.save(commessa));
                azienda.getClienti().add(clienteRepository.save(cliente));
                aziendaRepository.save(azienda);
            }
            else {
                throw new Exception("Il salvataggio della nuova commessa non è andato a buon fine");
            }
        }
        else {
            throw new Exception("Il salvataggio della nuova commessa non è andato a buon fine");
        }
        return null;
    }

    /**
     *
     * @param commessa
     * @param ragSocialeCliente
     * @param codiceCommessaOld
     * @return
     * @throws Exception
     */
    @Override
    public Commessa update(Commessa commessa, String ragSocialeCliente, String codiceCommessaOld) throws Exception {

        Optional<Commessa> commessaOpt = commessaRepository.findById(codiceCommessaOld);
        if(commessaOpt.isPresent()) {

            commessa.setCodiceCommessa(commessa.getCodiceCommessa());;
            Cliente cliente = clienteRepository.findByRagSociale(ragSocialeCliente);
            if(cliente != null) {

                Azienda azienda = aziendaRepository.findByNomeAzienda(cliente.getAzienda().getNomeAzienda());
                if(azienda != null) {
                    cliente.getCommesse().add(commessaRepository.save(commessa));
                    azienda.getClienti().add(clienteRepository.save(cliente));
                    aziendaRepository.save(azienda);
                }
                else {
                    throw new Exception("L'aggiornamento commessa non è andato a buon fine");
                }
            }
            else {
                throw new Exception("L'aggiornamento commessa non è andato a buon fine");
            }
        }
        return null;
    }

    /**
     *
     * @param commessa
     * @param ragioneSociale
     * @throws Exception
     */
    @Override
    public void delete(Commessa commessa, String ragioneSociale) throws Exception {

        Cliente cliente = clienteRepository.findByRagSociale(ragioneSociale);
        if(cliente != null) {

            Azienda azienda = aziendaRepository.findByNomeAzienda(cliente.getAzienda().getNomeAzienda());
            if(azienda != null) {

                azienda.getClienti().remove(cliente);
                cliente.getCommesse().remove(commessa);
                azienda.getClienti().add(clienteRepository.save(cliente));
                aziendaRepository.save(azienda);
                commessaRepository.delete(commessa);
            }
            else {
                throw new Exception("La cancellazione della commessa non è andata a buon fine");
            }
        }
        else {
            throw new Exception("La cancellazione della commessa non è andata a buon fine");
        }
    }
}
