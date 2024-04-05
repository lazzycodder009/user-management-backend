package com.example.entitlement.management.controller;

 
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entitlement.management.entity.User;

@RestController
public class UserController {

    List<User> users = new ArrayList<>();
    private void loadUsers(){
       
        User user1=  User.builder().firstName("Manish").lastName("Upadhyay").email("manish.upadhyay@google.com").build();
        User user2=  User.builder().firstName("Nikita").lastName("Tiwari").email("nikita.tiwari@gmail.com").build();
        User user3=  User.builder().firstName("Ananya").lastName("Upadhyay").email("ananya.upadhyay@yahoo.com").build();
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    @GetMapping("/users")
    public List<User> getUsers(){

        loadUsers();
        return users;
    }
    @GetMapping("/users/{firstName}")
    public User getUserByFirstName(@PathVariable String firstName){
        System.out.print(firstName);
        User usr= null;
       if ( users.size()>0){
             usr=   users.stream().filter(u-> u.getFirstName().equalsIgnoreCase(firstName)).findAny().orElse(null);
       }
       System.out.print(usr);
       return usr;

       
    }
    
}
