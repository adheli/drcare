package ie.ait.bteam.drcare;

import ie.ait.bteam.drcare.rest.controller.GeneralPractitionerController;
import ie.ait.bteam.drcare.rest.controller.UserRestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DrCareApplicationTests {

	private GeneralPractitionerController generalPractitionerController;
	private UserRestController userRestController;

	@Autowired
	public DrCareApplicationTests(GeneralPractitionerController generalPractitionerController,
								  UserRestController userRestController) {
		this.generalPractitionerController = generalPractitionerController;
		this.userRestController = userRestController;
	}

	@Test
	public void contextLoads() throws Exception{
		assertThat(generalPractitionerController).isNotNull();
		assertThat(userRestController).isNotNull();

	}

}
