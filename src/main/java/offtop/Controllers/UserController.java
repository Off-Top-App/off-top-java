package offtop.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import offtop.Config.UserRepository;
import offtop.Models.User;

@RestController
public class UserController{
    
    @Autowired
    UserRepository database;
    
    @PostMapping(value ="/offTop",consumes = "application/json")
    public User setUser (@RequestBody User user){
         return database.save(user);
    }
}
//1, "firstName", "lastName", "city", 20, "gender", "professional",
//"email", "username", "password", "createdAt", "deletedAt"