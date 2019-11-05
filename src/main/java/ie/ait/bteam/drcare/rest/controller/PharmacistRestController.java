package ie.ait.bteam.drcare.rest.controller;

import ie.ait.bteam.drcare.rest.dto.UserDTO;
import ie.ait.bteam.drcare.rest.service.PharmacistRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pharmacist")
public class PharmacistRestController {

    private PharmacistRestService pharmacistRestService;

    @Autowired
    public PharmacistRestController(PharmacistRestService pharmacistRestService) {
        this.pharmacistRestService = pharmacistRestService;
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO user, BindingResult result) {
        UserDTO createdPharmacist = pharmacistRestService.createPharmacist(user, result);

        return new ResponseEntity<>(createdPharmacist, HttpStatus.CREATED);
    }

}
