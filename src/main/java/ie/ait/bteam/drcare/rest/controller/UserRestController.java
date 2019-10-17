package ie.ait.bteam.drcare.rest.controller;

import ie.ait.bteam.drcare.rest.exceptions.EntityNotFound;
import ie.ait.bteam.drcare.rest.model.ResponseDTO;
import ie.ait.bteam.drcare.rest.model.UserDTO;
import ie.ait.bteam.drcare.rest.service.UserRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/user/")
public class UserRestController {

	private UserRestService userRestService;

	@Autowired
	public UserRestController(UserRestService userRestService) {
		this.userRestService = userRestService;
	}

	@GetMapping("create/firstUser")
	@ResponseBody
	public ResponseEntity<ResponseDTO<UserDTO>> createFirstAdmin() {
		UserDTO userToCreate = new UserDTO();
		userToCreate.setUsername("admin");
		userToCreate.setPassword("foobar");
		userToCreate.setName("Administrator");
		userToCreate.setEmail("admin@drcare.hse.ie");

		UserDTO createdUser = userRestService.createUserAdmin(userToCreate, null);

		return new ResponseEntity<>(new ResponseDTO<>(createdUser, "Created successfully."), HttpStatus.CREATED);
	}

	@PostMapping("create/admin")
	@ResponseBody
	public ResponseEntity<UserDTO> createUserAdmin(@RequestBody UserDTO userToCreate, BindingResult result) {
		UserDTO createdUser = userRestService.createUserAdmin(userToCreate, result);
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

	@GetMapping("list")
	public ResponseEntity<List<UserDTO>> listUsers() {
		return new ResponseEntity<>(userRestService.listUsers(), HttpStatus.OK);
	}
}
