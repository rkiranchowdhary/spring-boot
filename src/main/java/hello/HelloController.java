package hello;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping(value="/index",method=RequestMethod.GET)
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    
    @RequestMapping(value="/pro/id",method=RequestMethod.GET)
    public String index2() {
        return "Protected url";
    }
    
    @RequestMapping(value="/",method=RequestMethod.GET)
    public String hoe() {
        return "Home!!! protected";
    }

}