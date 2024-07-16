package com.example.ProVision_ERP.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProVision_ERP.Dto.ClientCreate;
import com.example.ProVision_ERP.Excepction.ClientNotFoundException;
import com.example.ProVision_ERP.Model.Client;
import com.example.ProVision_ERP.Repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;



    public List<Client> allUser () {
        System.out.println("ingreso a listar");
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }

    public Client getClientForId (Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client createClient (ClientCreate dto) {

        Client client = new Client();
        client.setName(dto.getName());
        client.setLastname(dto.getLastname());
        client.setEmail(dto.getEmail());
        client.setTelephone(dto.getTelephone());
        client.setAddress(dto.getAddress());
        return clientRepository.save(client);
    }

    public Client UpdateClient (Long id, ClientCreate dto) {
        Client client = clientRepository.findById(id)
        .orElseThrow(() -> new ClientNotFoundException(id));
        client.setName(dto.getName());
        client.setLastname(dto.getLastname());
        client.setEmail(dto.getEmail());
        client.setTelephone(dto.getTelephone());
        client.setAddress(dto.getAddress());

        return clientRepository.save(client);
    }
    

    
}
