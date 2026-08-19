package com.example.githublesson.service;

import com.example.githublesson.entity.User;
import com.example.githublesson.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UsersRepository usersRepository;

    public ResponseEntity<User> createUser(User user){
        return ResponseEntity.status(201).body(usersRepository.save(user));
    }

    public ResponseEntity<User> getUserById(int id){
        Optional<User> optionalUser = usersRepository.findById(id);
        if (optionalUser.isPresent()) {
            return ResponseEntity.status(200).body(optionalUser.get());
        } else {return ResponseEntity.status(404).build();}
    }

    public ResponseEntity<User> deleteUserById(int id){
        if (usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        } else {return ResponseEntity.status(404).build();}
    }
}
