package ie.ait.bteam.drcare.data.service;

import ie.ait.bteam.drcare.data.model.User;
import ie.ait.bteam.drcare.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User createUser(User user) {
		return this.userRepository.save(user);
	}

	public User findUser(User user) {
		return this.userRepository.findById(user.getId()).get();
	}

	public User findUser(Long userId) {
		return this.userRepository.findById(userId).get();
	}

	public User findUser(String username){return this.userRepository.findByUsername(username);}

	public List<User> findByStaffType(String staffType) {
		return this.userRepository.findByStaffType(staffType);
	}
}
