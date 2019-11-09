package ie.ait.bteam.drcare.rest.service;

import ie.ait.bteam.drcare.data.model.GeneralPractitioner;
import ie.ait.bteam.drcare.data.model.User;
import ie.ait.bteam.drcare.data.service.UserService;
import ie.ait.bteam.drcare.rest.dto.UserDTO;
import ie.ait.bteam.drcare.rest.translator.Translator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserRestServiceTest {

    UserRestService service ;

    UserService userService;
    Translator<User, UserDTO> userTranslator;

    @Before
    public void setUp() throws Exception {
        userService = Mockito.mock(UserService.class);
        userTranslator = Mockito.mock(Translator.class);
        service = new UserRestService(userService, userTranslator);
    }

    @Test
    public void listUserTypes() {
        assertNotNull(service);
        List<String> resultTypes = service.listUserTypes();

        System.out.println(resultTypes);
        assertNotNull(resultTypes);
        assertEquals(4, resultTypes.size());

    }

    private List<String> getTestUserTypes(){
        List<String> types = new ArrayList<>();
        types.add("GP");
        types.add("OTHER");

        return types;
    }

    private List<User> getSampleUsers(){
        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setEmail("test@test.com");
        user1.setName("tester");
        users.add(user1);

        return users;
    }

    @Test
    public void listUsers(){
        List<User> sampleUsers = getSampleUsers();
        Mockito.when(userService.findUsers()).thenReturn(sampleUsers);

        List<UserDTO> userDTOS = service.listUsers();

        assertNotNull(userDTOS);
        assertEquals(1, userDTOS.size());
    }
}
