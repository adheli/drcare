package ie.ait.bteam.drcare.rest.service;

import ie.ait.bteam.drcare.data.model.User;
import ie.ait.bteam.drcare.data.service.UserService;
import ie.ait.bteam.drcare.rest.dto.UserType;
import ie.ait.bteam.drcare.rest.exceptions.EntityNotFound;
import ie.ait.bteam.drcare.rest.dto.UserDTO;
import ie.ait.bteam.drcare.rest.translator.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
	public UserRestService(UserService userService, @Qualifier("userToUserDTOTranslator") Translator<User, UserDTO> userTranslator) {
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

	public UserDTO updateUser(UserDTO user, BindingResult result) {
		User userDetails = userService.findUser(user.getId());

		if (userDetails.getId() == user.getId()) {
			User updatedUser = userTranslator.translateTo(user);
			updatedUser = userService.updateUser(updatedUser, result);

			return userTranslator.translateFrom(updatedUser);
		} else {
			throw new EntityNotFound(user.getId());
		}

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

	public List<UserDTO> listUsersByType(String userType) {
		List<UserDTO> userDTOS = new ArrayList<>();
		userService.findByUserType(userType).forEach(user -> userDTOS.add(userTranslator.translateFrom(user)));
		return userDTOS;
  }
  
	public UserDTO searchUser(String username) {
		User searchedUser = userService.findUser(username);

		return userTranslator.translateFrom(searchedUser);
	}

	public List<UserDTO> searchUserByUsernameAndType(String username, String userType) {
		List<UserDTO> searchedUser = new ArrayList<>();
		userService.findUserByUsernameAndType(username, userType).forEach(user -> searchedUser.add(userTranslator.translateFrom(user)));

		return searchedUser;
	}

	public List<String> listUserTypes(){
		return Stream.of(UserType.values()).map(UserType::toString).collect(Collectors.toList());
	}

	public void deleteUser(Long userId) {
		userService.deleteUser(userId);
	}
}
