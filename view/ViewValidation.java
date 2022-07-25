package com.shopping.view;

/**
 * The class validates the input given by the user.
 * @author AswiniN
 *
 */
public class ViewValidation {
	/**
	 * It validates EmailId.
	 * @param emailId
	 * @return
	 */
	public static String validateEmailId(String emailId) {
			
		if (emailId != null && emailId.matches("^[A-Za-z0-9]{4,}+@[a-z]+.[a-z]{2,3}$")) {
			System.out.println("Valid Email Id");
		} else {
			System.out.println("Invalid");
		    emailId = LoginPortal.getEmailId();
	}	
		return emailId;
	}
	
	/**
	 * It validates Password.
	 * @param password
	 * @return
	 */
	public static String validatePassword(String password) {
	
		if (password.matches("^(.+)(?=.*[@#$%^&-+=()])(?=\\S+$).{6,10}$"))	{
		   System.out.println("Valid Password.");	
		} else {
			System.out.println("Invalid");
			password = LoginPortal.getPassword();
		}
		return password;
	}
}
