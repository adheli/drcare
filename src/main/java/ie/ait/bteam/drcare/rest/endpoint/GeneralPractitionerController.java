
package ie.ait.bteam.drcare.rest.endpoint;

import ie.ait.bteam.drcare.data.model.GeneralPractitioner;
import ie.ait.bteam.drcare.data.model.User;
import ie.ait.bteam.drcare.data.service.GeneralPractitionerService;
import ie.ait.bteam.drcare.rest.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/general-practitioner")
public class GeneralPractitionerController {

    private GeneralPractitionerService generalPractitionerService;

    @Autowired
    public GeneralPractitionerController(GeneralPractitionerService generalPractitionerService) {
        this.generalPractitionerService = generalPractitionerService;
    }

    @GetMapping("/ping")
    public String ping(){
        return "General Practitioner is fine!";
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public GeneralPractitioner create(@RequestBody GeneralPractitioner generalPractitioner){
       return generalPractitionerService.create(generalPractitioner);
    }

    @RequestMapping(value="/fetch", method = RequestMethod.GET)
    public GeneralPractitioner fetch(@RequestParam(value = "id") Long generalPractitionerId){
        return generalPractitionerService.get(generalPractitionerId);
    }

    @RequestMapping(value = {"/fetch-all"}, method = RequestMethod.GET)
    public List<GeneralPractitioner> fetchAll() {
        return generalPractitionerService.getAll();
    }

}
