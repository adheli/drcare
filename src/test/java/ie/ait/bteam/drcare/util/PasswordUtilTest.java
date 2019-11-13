package ie.ait.bteam.drcare.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtilTest {


    private PasswordUtil pUtil;

    @Before
    public void setUp() throws Exception {
        pUtil = new PasswordUtil();
    }

    @Test
    public void encode() {
        BCryptPasswordEncoder encoda = Mockito.mock(BCryptPasswordEncoder.class);
        String mockedResponse = "xxxxxxxxxx";
        Mockito.when(encoda.encode(Mockito.anyString())).thenReturn(mockedResponse);
        //ReflectionTestUtils.setField(pUtil,"encoder", encoda);
        pUtil.setEncoder(encoda);

        String result = pUtil.encode("password");

        System.out.println(result);
        Assert.assertNotNull(result);
        Assert.assertEquals(mockedResponse, result);
    }

}
