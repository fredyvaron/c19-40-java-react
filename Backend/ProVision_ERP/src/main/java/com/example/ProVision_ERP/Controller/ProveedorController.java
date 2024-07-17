package com.example.ProVision_ERP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProVision_ERP.Dto.ProviderDTO;
import com.example.ProVision_ERP.Model.Proveedores;
import com.example.ProVision_ERP.Services.ProveedorService;

@RequestMapping("/provider")
@RestController
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping()
    public ResponseEntity<List<Proveedores>> allprovider() {
        List<Proveedores> proveedores = proveedorService.allprovider();
        return ResponseEntity.ok(proveedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedores> getproviderById(@PathVariable Long id)  {
        Proveedores proveedores = proveedorService.findbyid(id);
        if (proveedores != null) {
            return ResponseEntity.ok(proveedores);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Proveedores> createprovider(@RequestBody ProviderDTO providerDTO){
        try {
            Proveedores proveedores = proveedorService.createprovider(providerDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(proveedores);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Proveedores> updateProvider(@PathVariable Long id, @RequestBody ProviderDTO providerDTO) {
        try {
            Proveedores proveedores = proveedorService.updateprovider(id, providerDTO);
            return ResponseEntity.ok().body(proveedores);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().build();
        }
    }

    
}
