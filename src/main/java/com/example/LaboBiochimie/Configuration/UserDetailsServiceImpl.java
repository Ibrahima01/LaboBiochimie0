package com.example.LaboBiochimie.Configuration;

import com.example.LaboBiochimie.Entities.AppUser;
//import com.example.LaboBiochimie.Entities.User;
import com.example.LaboBiochimie.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user=userService.loadUserByusername(username);
        return null;
    }
}
