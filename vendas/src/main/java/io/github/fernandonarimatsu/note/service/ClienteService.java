package io.github.fernandonarimatsu.note.service;

import io.github.fernandonarimatsu.note.model.Cliente;
import io.github.fernandonarimatsu.note.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private ClienteRepository repository;

    @Autowired
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public void salvarCliente(Cliente cliente){
       validarCliente(cliente);
       this.repository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente){
        //Aplica validações.
    }
}
