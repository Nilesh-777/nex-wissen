package proxy_pattern;

public class LoginFailedException extends Exception {
	public LoginFailedException(String msg) {
		super(msg);
	}
}
