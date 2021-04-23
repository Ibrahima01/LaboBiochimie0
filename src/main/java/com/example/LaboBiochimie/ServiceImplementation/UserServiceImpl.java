package com.example.LaboBiochimie.ServiceImplementation;

import com.example.LaboBiochimie.Entities.AppUser;
import com.example.LaboBiochimie.Repository.UserRepository;
import com.example.LaboBiochimie.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository appUserRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public AppUser SaveUser(String username,String password,String confirmedPassword) {
        AppUser  user=appUserRepository.findByUsername(username);
        if(user!=null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        AppUser appUser=new AppUser();
        appUser.setUsername(username);
        appUser.setActived(true);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUserRepository.save(appUser);
        //addRoleToUser(username,"USER");
        return appUser;
    }

    @Override
    public AppUser login(String email) {
        return null;
    }

    @Override
    public void UpdateUser(Long Id, AppUser user) {

    }

    @Override
    public void RemoveUser(Long Id) {

    }

    @Override
    public AppUser loadUserByusername(String username) {
        return appUserRepository.findByUsername(username);
    }
}