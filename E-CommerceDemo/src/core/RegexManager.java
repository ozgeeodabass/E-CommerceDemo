package core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexManager {

	public boolean checkEmailFormat(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
