package proxy_pattern;

class Logger {
	public void login() throws LoginFailedException {
		System.out.println("LogIn");
		if (true)
			throw new LoginFailedException("LOgin Failed.. Try again later");
	}

	public void logout() throws LogoutFailedException {
		System.out.println("LogOut");
		if (false)
			throw new LogoutFailedException("Log out failed");

	}

}

class Nexwave {
	public void learning() {
		System.out.println("Learning Service");
	}
}

class NexwaveProxy extends Nexwave {

	Logger logger = new Logger();

	public void learnigService() {
		try {
			logger.login();
			super.learning();
			logger.logout();
		} catch (LoginFailedException e) {
			System.out.println(e.getMessage());
		} catch (LogoutFailedException e) {
			System.out.println(e.getMessage());
		}
	}

}

public class ProxyPattern {
	public static void main(String[] args) {

		NexwaveProxy nexwaveProxy = new NexwaveProxy();
		nexwaveProxy.learnigService();

		System.out.println("Main method finished.....");

	}
}
