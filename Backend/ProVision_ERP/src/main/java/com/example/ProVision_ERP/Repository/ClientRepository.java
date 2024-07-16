package com.example.ProVision_ERP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProVision_ERP.Model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
