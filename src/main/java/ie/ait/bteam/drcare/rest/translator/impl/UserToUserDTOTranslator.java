package ie.ait.bteam.drcare.rest.translator.impl;

import ie.ait.bteam.drcare.data.model.User;
import ie.ait.bteam.drcare.rest.dto.MedicalStaffType;
import ie.ait.bteam.drcare.rest.dto.UserDTO;
import ie.ait.bteam.drcare.rest.translator.Translator;
import ie.ait.bteam.drcare.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author adheli.tavares
 *
 * Class to map an User model to an UserDTO model and vice-versa.
 */
@Component
@Qualifier("userToUserDTOTranslator")
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
		if(original.getUserType() != null){
			dto.setUserType(MedicalStaffType.valueOf(original.getUserType()));
		}


		return dto;
	}

	@Override
	public User translateTo(UserDTO copy) {
		User user = new User();
		user.setEmail(copy.getEmail());
		user.setId(copy.getId());
		user.setIsAdmin(copy.getIsAdmin());
		user.setName(copy.getName());
		user.setPassword(PasswordUtil.encode(copy.getPassword()));
		user.setUsername(copy.getUsername());
		if(copy.getUserType() != null){
			user.setUserType(copy.getUserType().toString());
		}


		return user;
	}
}
