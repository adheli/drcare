package ie.ait.bteam.drcare.data.validator;

import ie.ait.bteam.drcare.data.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		return (aClass.equals(User.class));
	}

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "user.name.empty");
		User userToValidate = (User) o;

		if (userToValidate.getIsAdmin()) {
			if (userToValidate.getUsername().trim().isEmpty())
				errors.rejectValue("username", "user.admin.username.empty");
			if (userToValidate.getPassword().trim().isEmpty())
				errors.rejectValue("password", "user.admin.password.empty");
			if (userToValidate.getEmail().trim().isEmpty())
				errors.rejectValue("email", "user.admin.email.empty");
		}
	}
}
