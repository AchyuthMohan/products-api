package org.example.Service;

import org.example.Entity.User;
import org.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RestController
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveNewUser(User user){
        return repository.save(user);
    }
    public List<User> getAllUsers(){
        return repository.findAll();
    }
    public User getUserById(int id){
        return repository.findById(id).orElse(null);
    }
    public String deleteById(int id){
        repository.deleteById(id);
        return "Successfully deleted";
    }
    public User update(User user){
        User existing=repository.findById(user.getId()).orElse(null);
        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        existing.setPassword(user.getPassword());
        return existing;
    }
}
