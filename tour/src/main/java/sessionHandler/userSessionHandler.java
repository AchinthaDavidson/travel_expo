package sessionHandler;

import customer.Customer;

public class userSessionHandler extends Customer {
	
	//super(id,Name,Email,Phone,password);
	private static String SessionID;
	private static long SessionCreateTime;
	private static String SessionEmail;
	private static String SessionPass;
	
	public String getSessionID() {
		return SessionID;
	}
	public void setSessionID(String sessionID) {
		SessionID = sessionID;
	}
	public long getSessionCreateTime() {
		return SessionCreateTime;
	}
	public static void setSessionCreateTime(long sessionCreateTime) {
		SessionCreateTime = sessionCreateTime;
	}
	public String getSessionEmail() {
		return SessionEmail;
	}
	public void setSessionEmail(String sessionEmail) {
		SessionEmail = sessionEmail;
	}
	public String getSessionPass() {
		return SessionPass;
	}
	public void setSessionPass(String sessionPass) {
		SessionPass = sessionPass;
	}
	public userSessionHandler(int id, String name, String email, String phone, String password, String sessionID,
			long sessionCreateTime, String sessionEmail, String sessionPass) {
		super(id, name, email, phone, password);
		SessionID = sessionID;
		SessionCreateTime = sessionCreateTime;
		SessionEmail = sessionEmail;
		SessionPass = sessionPass;
	}
	public userSessionHandler() {
		// TODO Auto-generated constructor stub
	}
	
		

}
