package com.example.hospital.repository.user;

import com.example.hospital.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findByUsername(String userRequest);

    public Optional<User> findByPassword(String userRequest);

}
