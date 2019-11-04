package ie.ait.bteam.drcare.data.service;

import ie.ait.bteam.drcare.data.model.User;
import ie.ait.bteam.drcare.data.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.persistence.MapKeyColumn;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userservice;

    UserRepository repo = Mockito.mock(UserRepository.class);


    @Before
    public void setUp() throws Exception {
        userservice = new UserService(repo);
        //userservice = Mockito.mock(UserService.class);
    }

    @Test
    public void createUser() {

        User myUser = new User();
        Mockito.when(repo.saveAndFlush(myUser)).thenReturn(myUser);

        User createdUser =  userservice.createUser(myUser);
        assertNotNull(createdUser);
        assertEquals(myUser,createdUser);
    }

    @Test
    public void findUser(){

        User newfind = new User();
        newfind.setUsername("austin");
        newfind.setId(12L);

        Mockito.when(repo.findUserByUsername("austin")).thenReturn(newfind);
        Mockito.when(repo.getOne(12L)).thenReturn(newfind);

        assertNotNull(userservice.findUser(newfind));
    }
}
