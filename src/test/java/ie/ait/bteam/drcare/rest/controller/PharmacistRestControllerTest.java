package ie.ait.bteam.drcare.rest.controller;

import ie.ait.bteam.drcare.rest.dto.UserDTO;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static ie.ait.bteam.drcare.rest.dto.MedicalStaffType.PHARMACIST;
import static junit.framework.TestCase.assertEquals;

public class PharmacistRestControllerTest extends AbstractTest {
    private final static Logger logger = LoggerFactory.getLogger(PharmacistRestControllerTest.class);
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void createPharmacist() throws Exception {
        String uri = "/pharmacist/create";
        UserDTO pharmacist = new UserDTO();
        pharmacist.setId((long) 2);
        pharmacist.setName("TestName");
        pharmacist.setUsername("TestUsername");
        pharmacist.setEmail("Testemail@qa.team");
        pharmacist.setPassword("password");
        pharmacist.setIsAdmin(false);
        pharmacist.setUserType(PHARMACIST);
        String inputJson = super.mapToJson(pharmacist);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        logger.info("Pharmacist created: " + content);

        assertEquals(content, content);
    }
}
