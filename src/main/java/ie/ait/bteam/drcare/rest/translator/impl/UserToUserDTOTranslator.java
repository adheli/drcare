package ie.ait.bteam.drcare.rest.translator.impl;

import ie.ait.bteam.drcare.data.model.User;
import ie.ait.bteam.drcare.rest.model.UserDTO;
import ie.ait.bteam.drcare.rest.translator.Translator;

/**
 * @author adheli.tavares
 *
 * Class to map an User model to an UserDTO model and vice-versa.
 */
public class UserToUserDTOTranslator implements Translator<User, UserDTO> {

	@Override
	public UserDTO translateFrom(User original) {
		UserDTO dto = new UserDTO();
		dto.setEmail(original.getEmail());
		dto.setId(original.getId());
		dto.setIsAdmin(original.getIsAdmin());
		dto.setName(original.getName());
		dto.setPassword(original.getPassword());
		dto.setUsername(original.getUsername());

		return dto;
	}

	@Override
	public User translateTo(UserDTO copy) {
		User user = new User();
		user.setEmail(copy.getEmail());
		user.setId(copy.getId());
		user.setIsAdmin(copy.getIsAdmin());
		user.setName(copy.getName());
		user.setPassword(copy.getPassword());
		user.setUsername(copy.getUsername());

		return user;
	}
}
