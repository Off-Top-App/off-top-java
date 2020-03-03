package offtop.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import offtop.Config.DatabaseRepo;
import offtop.Models.User;

@RestController
public class SetUserController{
    
    @Autowired
    DatabaseRepo database;

    @PostMapping("/offTop")
    public List<User> setUser(@RequestBody User user){
         database.save(user);
         return (List<User>) database.findAll();
    }
}