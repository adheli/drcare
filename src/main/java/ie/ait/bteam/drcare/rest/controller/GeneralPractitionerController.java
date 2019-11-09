
package ie.ait.bteam.drcare.rest.controller;

import ie.ait.bteam.drcare.data.model.GeneralPractitioner;
import ie.ait.bteam.drcare.data.service.GeneralPractitionerService;
import ie.ait.bteam.drcare.rest.dto.UserDTO;
import ie.ait.bteam.drcare.rest.exceptions.EntityNotFound;
import ie.ait.bteam.drcare.rest.service.UserRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value={"/general-practitioner", "/gp"})
public class GeneralPractitionerController {

    private UserRestService userRestService;
    @Autowired
    public GeneralPractitionerController(UserRestService userRestService) {
        this.userRestService = userRestService;
    }

    @GetMapping("/ping")
    public String ping(){
        return "General Practitioner is fine!";
    }

    @PostMapping("create")
    @ResponseBody
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userToCreate, BindingResult result) {
        UserDTO createdUser = userRestService.createUser(userToCreate, result);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("{userId}")
    @ResponseBody
    public ResponseEntity<UserDTO> userDetails(@PathVariable Long userId) {
        try {
            UserDTO userDetails = userRestService.userDetails(userId);
            return new ResponseEntity<>(userDetails, HttpStatus.OK);
        } catch (EntityNotFound entityNotFound) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("search/{username}")
    @ResponseBody
    public ResponseEntity<UserDTO> searchUsers(@PathVariable String username) {
        try {
            UserDTO searchedUser = userRestService.searchUser(username);
            return new ResponseEntity<>(searchedUser, HttpStatus.OK);
        } catch (EntityNotFound entityNotFound) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("list")
    public ResponseEntity<List<UserDTO>> listUsers() {
        return new ResponseEntity<>(userRestService.listUsers(), HttpStatus.OK);
    }

    @GetMapping("listUserTypes")
    public ResponseEntity<List<String>> listUserTypes() {
        return new ResponseEntity<>(userRestService.listUserTypes(), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userRestService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
