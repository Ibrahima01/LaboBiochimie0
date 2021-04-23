package com.example.LaboBiochimie.Service;

import com.example.LaboBiochimie.Entities.AppUser;

//import com.example.LaboBiochimie.Entities.User;

public interface UserService {
    public AppUser SaveUser(String username,String password,String confirmedPassword);
    public AppUser login(String email);
    public void UpdateUser(Long Id, AppUser user);
    public void RemoveUser(Long Id);
    public AppUser loadUserByusername(String username);

}