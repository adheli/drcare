package ie.ait.bteam.drcare.data.service;

import ie.ait.bteam.drcare.data.model.User;
import ie.ait.bteam.drcare.data.repository.UserRepository;
import ie.ait.bteam.drcare.data.validator.UserValidator;
import ie.ait.bteam.drcare.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User createUser(User user) {
		return this.userRepository.saveAndFlush(user);
	}

	public User createUser(User user, Errors errors) {
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, errors);
		return this.userRepository.saveAndFlush(user);
	}

	public User updateUser(User user, Errors errors) {
		// UserValidator userValidator = new UserValidator();
		// userValidator.validate(user, errors);

		return this.userRepository.save(user);
	}

	public User findUser(User user) {
		if (null != user.getUsername())
			return userRepository.findUserByUsername(user.getUsername());
		return this.userRepository.getOne(user.getId());
	}

	public User findUser(String userName) {
		return this.userRepository.findUserByUsername(userName);
	}

	public List<User> findUserByUsernameAndType(String username, String userType) {
		return this.userRepository.findByUsernameAndUserType(username, userType);
	}

	public User findUser(Long userId) {
		return this.userRepository.getOne(userId);
	}

	public List<User> findPatients() {
		return this.userRepository.findPatients();
	}

	public List<User> findByUserType(String userType) {
		return this.userRepository.findByUserType(userType);
	}

	public List<User> findUsers() {
		return this.userRepository.findAll();
	}

	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}

    public User loginUser(String email, String username, String password) {
		User foundUser = null;
		if(StringUtils.isEmpty(email) && StringUtils.isEmpty(username)){
			return foundUser;
		}

		if(StringUtils.isEmpty(email)){
			foundUser = userRepository.findUserByUsername(username);
		}else {
			foundUser = userRepository.findUserByEmail(email);
		}

		if(foundUser == null){
			return null;
		}

		if(! PasswordUtil.matches(password, foundUser.getPassword())){
			return null;
		}

		return foundUser;
    }
}
