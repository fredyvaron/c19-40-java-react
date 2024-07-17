package com.example.ProVision_ERP.Services;

import java.nio.file.ProviderNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProVision_ERP.Dto.ProviderDTO;
import com.example.ProVision_ERP.Excepction.ProveedorNotFoundException;
import com.example.ProVision_ERP.Model.Proveedores;
import com.example.ProVision_ERP.Repository.ProveedorRepository;

@Service
public class ProveedorService {
    
    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedores> allprovider () {
        List<Proveedores> providers = new ArrayList<>();

        proveedorRepository.findAll().forEach(providers::add);

        return providers;
    }

    public Proveedores createprovider (ProviderDTO dto) {
        Proveedores provider = new Proveedores();

        provider.setName(dto.getName());
        provider.setAddress(dto.getAddress());
        provider.setEmail(dto.getEmail());
        provider.setTelephone(dto.getTelephone());
        return proveedorRepository.save(provider);
    }

    public Proveedores findbyid (Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public Proveedores updateprovider (Long id, ProviderDTO dto) {
        Proveedores proveed = proveedorRepository.findById(id)
        .orElseThrow(()-> new ProveedorNotFoundException(id));
        
        proveed.setName(dto.getName());
        proveed.setEmail(dto.getEmail());
        proveed.setAddress(dto.getAddress());
        proveed.setTelephone(dto.getTelephone());

        return proveedorRepository.save(proveed);
    }
}
