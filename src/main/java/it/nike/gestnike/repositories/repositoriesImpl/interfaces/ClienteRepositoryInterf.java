package it.nike.gestnike.repositories.repositoriesImpl.interfaces;

public interface ClienteRepositoryInterf<S, ID> {


    S save(S cliente, String nomeAzienda) throws Exception;

    S update(S cliente, String ragSocialeCliente, String nomeAzienda) throws Exception;

    void delete(S cliente, String nomeAzienda) throws Exception;
}
