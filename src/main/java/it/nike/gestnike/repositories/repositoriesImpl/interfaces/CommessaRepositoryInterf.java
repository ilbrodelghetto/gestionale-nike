package it.nike.gestnike.repositories.repositoriesImpl.interfaces;

import it.nike.gestnike.models.data_access.Commessa;
import it.nike.gestnike.repositories.CommessaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommessaRepositoryInterf<S, ID> {


    S save(S commessa, String ragSocialeCliente) throws Exception;

    S update(S commessa, String ragSocialeCliente, String codiceCommessaOld) throws Exception;

    void delete(S commessa, String ragioneSociale) throws Exception;

}
