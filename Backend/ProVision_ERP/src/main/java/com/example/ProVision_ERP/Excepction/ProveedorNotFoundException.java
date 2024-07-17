package com.example.ProVision_ERP.Excepction;

public class ProveedorNotFoundException extends RuntimeException{
    public ProveedorNotFoundException(Long id) {
        super("Provider with ID " + id + " not found");
    }
}
