package com.example.LaboBiochimie.Repository;

import com.example.LaboBiochimie.Entities.AppUser;
//import com.example.LaboBiochimie.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    public AppUser findByUsername(String username);
}