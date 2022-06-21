package com.mongodb.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepo userRepo;

    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }


    public boolean existsByEmail(String email) {
        return userRepo.existsByEmail(email);
    }


    public void saveAll(List<User> users) {
        userRepo.saveAll(users);
    }


    public List<User> findAll() {
        return userRepo.findAll();
    }


    public User save(User user) {
        return userRepo.save(user);
    }


    public void removeById(String id) {
        userRepository.deleteById(id);
    }

    public List<User> search(String keyword) {
        return userRepository.search(keyword);
    }

    public User update(User user) {
        return userRepo.save(user);
    }
}
