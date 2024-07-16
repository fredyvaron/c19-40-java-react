package com.example.ProVision_ERP.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProVision_ERP.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
  Optional<User> findByEmail(String email);
}
