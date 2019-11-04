package ie.ait.bteam.drcare.rest.service;

import ie.ait.bteam.drcare.data.model.User;
import ie.ait.bteam.drcare.data.service.UserService;
import ie.ait.bteam.drcare.rest.dto.MedicalStaffType;
import ie.ait.bteam.drcare.rest.exceptions.EntityNotFound;
import ie.ait.bteam.drcare.rest.dto.UserDTO;
import ie.ait.bteam.drcare.rest.translator.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author adheli.tavares
 */
@Service
public class UserRestService {

	private UserService userService;
	private Translator<User, UserDTO> userTranslator;

	@Autowired
	public UserRestService(UserService userService, Translator<User, UserDTO> userTranslator) {
		this.userService = userService;
		this.userTranslator = userTranslator;
	}

	public void setUserServiceForTest(UserService userService){
		this.userService = userService;
	}

	public UserDTO createUser(UserDTO user, BindingResult result) {
		User createdUser = userTranslator.translateTo(user);
		createdUser = userService.createUser(createdUser, result);

		return userTranslator.translateFrom(createdUser);
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

	public List<String> listUserTypes(){
		return Stream.of(MedicalStaffType.values()).map(MedicalStaffType::toString).collect(Collectors.toList());
	}

	public void deleteUser(Long userId) {
		userService.deleteUser(userId);
	}
}
