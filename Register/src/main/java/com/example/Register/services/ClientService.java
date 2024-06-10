package com.example.Register.services;

import com.example.Register.models.Client;
import com.example.Register.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client findByid (Long id) {
        Optional<Client> client = this.clientRepository.findById(id);
        return client.orElseThrow(() -> new RuntimeException(String.format("""
                Cadastro não encontrado!
                ID: %d
                NAME: %s
                """,id, Client.class.getName())));
    }

    @Transactional
    public Client create( Client obj) {
        obj.setId(null);
        obj = this.clientRepository.save(obj);
        return obj;
    }

    @Transactional
    public Client update(Client obj, Long id) {
        Client newObj = findByid(id);
        newObj.setCode(obj.getCode());
        newObj.setFictitious(obj.getFictitious());
        newObj.setName(obj.getName());
        return this.clientRepository.save(newObj);
    }

    public void delete (Long id) {
        findByid(id);
        try {
            this.clientRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(String.format("""
                    Cadastro não encontrado, ou possuí relação com outra entidade!
                    """));
        }
    }

}
