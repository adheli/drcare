package ie.ait.bteam.drcare.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

	private static BCryptPasswordEncoder encoder;

	public PasswordUtil(){
		encoder = new BCryptPasswordEncoder();
	}

	public void setEncoder(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
	}

	public static String encode(String password) {
		return encoder.encode(password);
	}
}
