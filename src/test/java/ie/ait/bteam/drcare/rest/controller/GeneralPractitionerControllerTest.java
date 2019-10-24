package ie.ait.bteam.drcare.rest.controller;

import ie.ait.bteam.drcare.rest.controller.GeneralPractitionerController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class GeneralPractitionerControllerTest {

    private GeneralPractitionerController generalPractitionerController;

    @Before
    public void setUp() throws Exception {
        generalPractitionerController = Mockito.mock(GeneralPractitionerController.class);
        //hseAdmin = new HSEAdmin();

    }

    @Test
    public void pingAdmin() {
        assertNotEquals("GP is fine!", generalPractitionerController.ping());
    }
}