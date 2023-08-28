//import model to use and repo to use
package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

//use restcontroller
//use requestmapping to map http request/ note: it is same as app.get at nodejs inside the bracket put the endpoint url
@RestController
@CrossOrigin(origins = "http://localhost:5173") // Replace with your frontend's URL
@RequestMapping(value="/user")
public class UserController { 
    
    //inject repo
    @Autowired
    UserRepo userRepo;

    //post/create
    //user in node is req and return is res 
    @PostMapping("/register")
    User addUser(@RequestBody User user){

        userRepo.save(user);//in node repo is prisma for example prisma.user.create if it in node 
        return user;
    }

    //getall
    @GetMapping("/alluser")
    List<User> getUser(){

        return userRepo.findAll();
    }

    //getone
    @GetMapping("/{idUser}")
    public User getOneUser(@PathVariable String idUser){
        return userRepo.findById(idUser).orElse(null);
    }

    //1.for put first you need to make function and isinde the parameter you must use @PathVariable to get the id from url 
    //2.next you create new instance of user to find the user by the id from url 
    //3.then use repo and setter function and change the info.   #inside the setter function put the info that has been sent from front end, in node user.getusername is req.body.username
    @PutMapping(value="{idUser}")
    public User updateUser (@PathVariable String idUser, @RequestBody User user){
        User updateUser = userRepo.findById(idUser).get();
        updateUser.setUsername(user.getUsername());
        updateUser.setPassword(user.getPassword());
        return userRepo.save(updateUser);
    }

    //delete
    //same as put you must find first the user of the id
    @DeleteMapping(value="{idUser}")
    public String deleteUser(@PathVariable String idUser){
        User deleteUser = userRepo.findById(idUser).get();
        userRepo.delete(deleteUser);
        return "Deleted";
    }
} 

