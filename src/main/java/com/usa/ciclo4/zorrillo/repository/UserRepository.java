package com.usa.ciclo4.zorrillo.repository;

import java.util.List;
import java.util.Optional;

import com.usa.ciclo4.zorrillo.interfaces.UserCrudRepository;
import com.usa.ciclo4.zorrillo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    public User save(User user) {
        return userCrudRepository.save(user);
    }

    public boolean emailExist(String email) {
        Optional<User> user = userCrudRepository.findByEmail(email);
        return !user.isEmpty();
    }

    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

}
