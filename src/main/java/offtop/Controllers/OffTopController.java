package offtop.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OffTopController{

    @GetMapping("/Test")
        public String test(){
            return "working";
        }

    @GetMapping("/Rest")
    public String Test(){
        return "Api works";
    }
}
