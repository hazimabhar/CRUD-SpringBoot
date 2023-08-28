//import model for the selected repo, if the repo is user repo then import model user
package com.example.demo.repository;
import com.example.demo.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

//use interface and then extend with Jpa repository
public interface UserRepo extends JpaRepository<User,String> {

    
}
