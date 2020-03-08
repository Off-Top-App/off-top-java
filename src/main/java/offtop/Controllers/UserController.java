package offtop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import offtop.Repository.UserRepository;
import offtop.Models.User;

@RestController
public class UserController{
    
    @Autowired
    UserRepository database;
    
    @PostMapping(value ="/setUser")
    public User setUser (@RequestBody User user){
         return database.save(user);
    }
}
