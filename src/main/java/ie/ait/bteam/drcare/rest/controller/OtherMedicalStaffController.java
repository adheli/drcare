package ie.ait.bteam.drcare.rest.controller;

import ie.ait.bteam.drcare.data.model.GeneralPractitioner;
import ie.ait.bteam.drcare.data.model.OtherMedicalStaff;
import ie.ait.bteam.drcare.data.service.GeneralPractitionerService;
import ie.ait.bteam.drcare.data.service.OtherMedicalStaffService;
import ie.ait.bteam.drcare.data.service.UserService;
import ie.ait.bteam.drcare.rest.dto.OtherMedicalStaffDTO;
import ie.ait.bteam.drcare.rest.dto.UserDTO;
import ie.ait.bteam.drcare.util.ModelConversionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Pelumi.Oyefeso on 05-Nov-2019
 */
@RestController
@RequestMapping("/other")
public class OtherMedicalStaffController {
    private OtherMedicalStaffService otherMedicalStaffService;



    @Autowired
    public OtherMedicalStaffController(OtherMedicalStaffService otherMedicalStaffService) {
        this.otherMedicalStaffService = otherMedicalStaffService;
    }

    @GetMapping("/ping")
    public String ping(){
        return "Other Medical Staff is fine!";
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public ResponseEntity<OtherMedicalStaffDTO> create(@RequestBody UserDTO userToCreate, BindingResult result){
        OtherMedicalStaffDTO otherMedicalStaffDTO = otherMedicalStaffService.create(userToCreate, result);
        return new ResponseEntity<>(otherMedicalStaffDTO, HttpStatus.CREATED);  
    }

    /*@RequestMapping(value="/update", method = RequestMethod.POST)
    public ResponseEntity<OtherMedicalStaffDTO> update(@RequestBody UserDTO userToCreate, BindingResult result){
        OtherMedicalStaffDTO otherMedicalStaffDTO = otherMedicalStaffService.update(userToCreate, result);
        return new ResponseEntity<>(otherMedicalStaffDTO, HttpStatus.OK);
    }*/

    @RequestMapping(value="/fetch/{userId}", method = RequestMethod.GET)
    public ResponseEntity<OtherMedicalStaffDTO> fetch(@PathVariable("userId") Long userId){
        OtherMedicalStaffDTO otherMedicalStaffDTO = otherMedicalStaffService.get(userId);
        if(otherMedicalStaffDTO == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(otherMedicalStaffDTO, HttpStatus.OK);
    }

    @RequestMapping(value={"/search/{username}"}, method = RequestMethod.GET)
    public ResponseEntity<List<OtherMedicalStaffDTO>> search(@PathVariable("username") String username){
        List<OtherMedicalStaffDTO> otherMedicalStaffDTOs = otherMedicalStaffService.get(username);
        if(otherMedicalStaffDTOs == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(otherMedicalStaffDTOs, HttpStatus.OK);
    }

    @RequestMapping(value={"/search/"}, method = RequestMethod.GET)
    public ResponseEntity<List<OtherMedicalStaffDTO>> searchEmpty(){
        List<OtherMedicalStaffDTO> otherMedicalStaffDTOs = otherMedicalStaffService.get("");
        if(otherMedicalStaffDTOs == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(otherMedicalStaffDTOs, HttpStatus.OK);
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public ResponseEntity<List<OtherMedicalStaffDTO>> fetchAll() {
        List<OtherMedicalStaffDTO> otherMedicalStaffDTOS =  otherMedicalStaffService.getAll();
        if(otherMedicalStaffDTOS == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(otherMedicalStaffDTOS, HttpStatus.OK);
    }
}
