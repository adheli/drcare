package ie.ait.bteam.drcare.rest.controller;

import ie.ait.bteam.drcare.rest.dto.UserDTO;
import ie.ait.bteam.drcare.rest.exceptions.EntityNotFound;
import ie.ait.bteam.drcare.rest.dto.UserType;
import ie.ait.bteam.drcare.rest.service.UserRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ie.ait.bteam.drcare.rest.dto.UserType.PHARMACIST;

@Controller
@RequestMapping("/pharmacist")
public class PharmacistRestController {

    private UserRestService userRestService;

    @Autowired
    public PharmacistRestController(UserRestService userRestService) {
        this.userRestService = userRestService;
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO user, BindingResult result) {
        UserDTO createdPharmacist = userRestService.createUser(user, result);

        return new ResponseEntity<>(createdPharmacist, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO user, BindingResult result) {
        UserDTO updatedPharmacist = userRestService.updateUser(user, result);

        return new ResponseEntity<>(updatedPharmacist, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDTO>> listUsers() {
        return new ResponseEntity<>(userRestService.listUsersByType(UserType.PHARMACIST.name()), HttpStatus.OK);
    }

    @GetMapping("/search/{username}")
    @ResponseBody
    public ResponseEntity<List<UserDTO>> searchUser(@PathVariable String username) {
        try {
            List<UserDTO> searchedUser = userRestService.searchUserByUsernameAndType(username, PHARMACIST.name());
            return new ResponseEntity<>(searchedUser, HttpStatus.OK);
        } catch (EntityNotFound entityNotFound) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
