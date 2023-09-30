package com.kahvana.challenge.service;

import com.kahvana.challenge.entity.User;
import com.kahvana.challenge.repository.UserRepository;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.jvnet.hk2.annotations.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Inject
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
    public Optional<User> findById (Long id){
        return userRepository.findById(id);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

}
