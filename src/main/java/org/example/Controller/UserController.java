package org.example.Controller;

import org.example.Entity.User;
import org.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    @GetMapping
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id){
        return service.getUserById(id);
    }
    @PostMapping
    public User addNewUser(@RequestBody User user){
        return service.saveNewUser(user);
    }
    @PutMapping
    public User updateUser(@RequestBody User user){
        return service.update(user);
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id){
        return service.deleteById(id);
    }
}
