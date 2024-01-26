package com.pack.fiaraoccaz.service;
import com.pack.fiaraoccaz.repository.UserRepository;
import com.pack.fiaraoccaz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User loginUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
    public User findUser(Long id){
        return userRepository.findById(id).get();
    }

    // Autres méthodes de gestion des utilisateurs si nécessaire
}
