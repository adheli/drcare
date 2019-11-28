package ie.ait.bteam.drcare.rest.security.jwt;

import ie.ait.bteam.drcare.data.model.User;
import ie.ait.bteam.drcare.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetails {


    private UserRepository userRepository;

    private String email;
    private String userType;

    @Autowired
    public MyUserDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userRepository.findUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }

        setUserInfo(user.getEmail(), user.getUserType());

        return org.springframework.security.core.userdetails.User//
                .withUsername(username)//
                .password(user.getPassword())//
                .authorities(user.getUserType())//
                .accountExpired(false)//
                .accountLocked(false)//
                .credentialsExpired(false)//
                .disabled(false)//
                .build();
    }

    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        final User user = userRepository.findUserByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User '" + email + "' not found");
        }

        setUserInfo(user.getEmail(), user.getUserType());

        return org.springframework.security.core.userdetails.User//
                .withUsername(email)//
                .password(user.getPassword())//
                .authorities(user.getUserType())//
                .accountExpired(false)//
                .accountLocked(false)//
                .credentialsExpired(false)//
                .disabled(false)//
                .build();
    }

    private void setUserInfo(String mail, String type){
        this.email = mail;
        this.userType = type;
    }

    public String getEmail() {
        return email;
    }

    public String getUserType() {
        return userType;
    }
}
