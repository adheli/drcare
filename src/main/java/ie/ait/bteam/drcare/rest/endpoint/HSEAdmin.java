package ie.ait.bteam.drcare.rest.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hse-admin")

public class HSEAdmin {


    @GetMapping("/ping")
    public String pingAdmin(){
        return "HSE Admin is fine!";
    }

}
