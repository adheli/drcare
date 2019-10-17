package ie.ait.bteam.drcare.rest.service;

import ie.ait.bteam.drcare.data.model.User;
import ie.ait.bteam.drcare.data.service.UserService;
import ie.ait.bteam.drcare.data.validator.UserValidator;
import ie.ait.bteam.drcare.rest.exceptions.EntityNotFound;
import ie.ait.bteam.drcare.rest.model.UserDTO;
import ie.ait.bteam.drcare.rest.translator.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRestService {

	private UserService userService;
	private Translator<User, UserDTO> userTranslator;

	@Autowired
	public UserRestService(UserService userService, Translator<User, UserDTO> userTranslator) {
		this.userService = userService;
		this.userTranslator = userTranslator;
	}

	public UserDTO createUserAdmin(UserDTO user, BindingResult result) {
		user.setIsAdmin(true);

		User createdUser = userTranslator.translateTo(user);

		if (result != null) {
			UserValidator userValidator = new UserValidator();
			userValidator.validate(createdUser, result);
		}

		return userTranslator.translateFrom(userService.createUser(createdUser));
	}

	public UserDTO userDetails(Long userId) {
		User userDetails = userService.findUser(userId);

		if (userDetails != null)
			return userTranslator.translateFrom(userDetails);
		else throw new EntityNotFound(userId);
	}

	public List<UserDTO> listUsers() {
		List<UserDTO> userDTOS = new ArrayList<>();
		userService.findUsers().forEach(user -> userDTOS.add(userTranslator.translateFrom(user)));
		return userDTOS;
	}
}
