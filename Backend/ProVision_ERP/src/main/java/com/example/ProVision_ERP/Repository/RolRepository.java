package com.example.ProVision_ERP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProVision_ERP.Model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
    Rol findByName(String name);
}
