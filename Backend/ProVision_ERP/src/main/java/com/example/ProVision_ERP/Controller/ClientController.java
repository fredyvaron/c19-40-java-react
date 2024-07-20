package com.example.ProVision_ERP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProVision_ERP.Dto.ClientCreate;
import com.example.ProVision_ERP.Excepction.ClientNotFoundException;
import com.example.ProVision_ERP.Model.Client;
import com.example.ProVision_ERP.Services.ClientService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RequestMapping("/cliente")
@RestController
@SecurityRequirement(name = "bearer-key")
public class ClientController {

    @Autowired
    private ClientService clientService;

    
    @GetMapping
    public ResponseEntity<List<Client>> allClient(){
        List<Client> client = clientService.allUser();

        return ResponseEntity.ok(client);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientForId(@PathVariable Long id) {
        System.out.println(id);
        Client client = clientService.getClientForId(id);
        if (client != null) {
            return ResponseEntity.ok(client);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/create")
    public ResponseEntity<Client> createClient(@RequestBody ClientCreate dto ) {
        try {
            Client client = clientService.createClient(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(client);
        } catch (IllegalArgumentException e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().body(null);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody ClientCreate dto) {
        try {
            Client client = clientService.UpdateClient(id, dto);
            return ResponseEntity.ok().body(client);  
        } catch (ClientNotFoundException e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().build();
        }

    }
}
