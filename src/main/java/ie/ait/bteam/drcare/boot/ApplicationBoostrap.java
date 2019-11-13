package ie.ait.bteam.drcare.boot;

import ie.ait.bteam.drcare.data.model.User;
import ie.ait.bteam.drcare.data.repository.UserRepository;
import ie.ait.bteam.drcare.data.service.UserService;
import ie.ait.bteam.drcare.util.PasswordUtil;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationBoostrap implements ApplicationListener<ContextRefreshedEvent> {

	private final static Logger logger = LoggerFactory.getLogger(ApplicationBoostrap.class);

	private UserService userService;

	@Autowired
	public ApplicationBoostrap(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initialize();
	}

	private void initialize() {
		User userAdmin = new User();
		userAdmin.setUsername("admin");
		userAdmin.setPassword(new PasswordUtil().encode("foobar"));
		userAdmin.setName("Administrator");
		userAdmin.setEmail("admin@drcare.hse.ie");
		userAdmin.setIsAdmin(true);

		if (null == userService.findUser(userAdmin)) {
			userAdmin = userService.createUser(userAdmin);
			logger.info("User admin created: " + userAdmin.getUsername());
		} else
			logger.info("User admin exists: " + userAdmin.getUsername());

	}
}
