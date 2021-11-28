package com.usa.ciclo4.zorrillo.interfaces;

import java.util.Optional;
import com.usa.ciclo4.zorrillo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
}
