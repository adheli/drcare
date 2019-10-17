package ie.ait.bteam.drcare.rest.endpoint;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class HSEAdminTest {

    private HSEAdmin hseAdmin;

    @Before
    public void setUp() throws Exception {
       // hseAdmin = Mockito.mock(HSEAdmin.class);
        hseAdmin = new HSEAdmin();
    }

    @Test
    public void pingAdmin() {
        assertEquals("HSE Admin is fine!",hseAdmin.pingAdmin());
    }
}