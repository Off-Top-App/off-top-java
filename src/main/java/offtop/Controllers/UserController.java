package offtop.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import offtop.Repository.UserRepository;
import offtop.Models.User;

@RestController
public class UserController{

    @Autowired
    UserRepository userRepository;
    
    @GetMapping(value = "/user/{email}")
    public User getUser( @PathVariable("email")String email) {
        User user = userRepository.findByEmail(email).get(0);
        return user;
        
    }
    
    
    
    @PostMapping(value ="/setUser")
    public User setUser (@RequestBody User user){
        System.out.println("***Post Request Created Successfully***");
         return userRepository.save(user);
    }
}
