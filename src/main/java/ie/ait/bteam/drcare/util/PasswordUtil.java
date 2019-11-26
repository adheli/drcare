package ie.ait.bteam.drcare.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

	public static String encode(String password) {
		return new BCryptPasswordEncoder().encode(password);
	}

	public static boolean matches(String password, String encodedPassword){
		return new BCryptPasswordEncoder().matches(password, encodedPassword);
	}
}
