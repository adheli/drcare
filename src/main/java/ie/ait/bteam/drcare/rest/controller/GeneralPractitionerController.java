
package ie.ait.bteam.drcare.rest.controller;

import ie.ait.bteam.drcare.data.model.GeneralPractitioner;
import ie.ait.bteam.drcare.data.service.GeneralPractitionerService;
import ie.ait.bteam.drcare.rest.dto.UserDTO;
import ie.ait.bteam.drcare.rest.dto.UserType;
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
        userToCreate.setUserType(UserType.GP);
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

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO user, BindingResult result) {
        UserDTO updatedPharmacist = userRestService.updateUser(user, result);
        if(updatedPharmacist == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(updatedPharmacist, HttpStatus.OK);
    }

    @GetMapping("search/{username}")
    @ResponseBody
    public ResponseEntity<List<UserDTO>> searchUsers(@PathVariable String username) {
        try {
            List<UserDTO> searchedUser = userRestService.searchUserByUsernameAndType(username, UserType.GP.name());
            return new ResponseEntity<>(searchedUser, HttpStatus.OK);
        } catch (EntityNotFound entityNotFound) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("list")
    public ResponseEntity<List<UserDTO>> listUsers() {
        return new ResponseEntity<>(userRestService.listUsersByType(UserType.GP.name()), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userRestService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
