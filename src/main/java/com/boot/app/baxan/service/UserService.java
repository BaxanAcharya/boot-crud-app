package com.boot.app.baxan.service;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.app.baxan.model.User;

@Repository
public interface UserService extends JpaRepository<User, Integer>{

	public User findByUsernameAndPassword(String username, String password);
}
