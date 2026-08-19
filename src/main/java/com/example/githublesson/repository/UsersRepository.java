package com.example.githublesson.repository;

import com.example.githublesson.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository <User,Integer> {}
