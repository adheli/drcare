package ie.ait.bteam.drcare.data.service;

import ie.ait.bteam.drcare.data.model.User;
import ie.ait.bteam.drcare.data.repository.UserRepository;
import ie.ait.bteam.drcare.data.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.List;

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

	public User findUser(User user) {
		if (null != user.getUsername())
			return userRepository.findUserByUsername(user.getUsername());
		return this.userRepository.getOne(user.getId());
	}

	public User findUser(String userName) {
		return this.userRepository.findUserByUsername(userName);
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
}
