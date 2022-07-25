package com.shopping.view;

import java.util.Scanner;

import com.shopping.controller.AuthenticationController;
import com.shopping.controller.ProductsController;
import com.shopping.dao.User;

/**
 * It gets input from user.
 * @author AswiniN
 *
 */
public class LoginPortal {
	public static final Scanner SCANNER = new Scanner(System.in);
	private static final AuthenticationController authenticationController = new AuthenticationController();
	final static User user = new User();
	
	/**
	 * It gets Login choice.
	 */
	public static void getLoginChoice() {	
		System.out.println("1. SignUp  2. SignIn");
		
		try {
		    user.setPreferredChoice(Integer.parseInt(SCANNER.next())); 
		  
            if (user.getPreferredChoice() == 1 || user.getPreferredChoice() == 2) {
            	LoginPortal.getUserChoice(user);
		  	} else {
		  		System.out.println("Invalid input");
		  		LoginPortal.getLoginChoice();
		  	}	
		} catch (NumberFormatException e) {
			System.out.println("You should enter a valid input!");
			LoginPortal.getLoginChoice();
		}
	}
	
	/**
	 * It gets the type of user either admin or user. 
	 * @param user
	 */
	private static void getUserChoice(User user) {
		System.out.println("1. Admin  2. User");
		
		try {
			user.setTypeOfUser(Integer.parseInt(SCANNER.next()));
			
			if (user.getTypeOfUser() == 1 || user.getTypeOfUser() == 2) {
				LoginPortal.signUpAndSignIn(user);	
			} else {
				LoginPortal.getUserChoice(user);
			}
		} catch (NumberFormatException e) {
			System.out.println("You should enter a valid input!");
			LoginPortal.getUserChoice(user);		
		}
	} 
	
	/**
	 * It routes the user based on the selected choice.
	 * @param user
	 */
	public static void signUpAndSignIn(User user) {
		
		user.setEmailId(getEmailId());
		
		boolean emailStatus = authenticationController.validateEmailId(user.getEmailId());
		checkEmail(emailStatus,user);
		
		if(user.getPreferredChoice() == 2) {
			checkPassword(user);
		} else if (user.getTypeOfUser() == 1){
			boolean isValidKey =LoginPortal.checkKey(user);
		} 
			user.setPassword(LoginPortal.getPassword());
			authenticationController.insertData(user);	
	}
	
	
	public static String getEmailId() {
		System.out.println("Enter EmailId:");
		return ViewValidation.validateEmailId(SCANNER.next());
	}
	
	public static String getPassword() {
		System.out.println("Enter Password:");
		return ViewValidation.validatePassword(LoginPortal.SCANNER.next());
	}
	
	/**
	 * It gets authenticator key if the user is admin.
	 * @param user
	 * @return
	 */
	private static boolean checkKey(User user) {
		System.out.println("Enter Key:");
		
		if("admin".equals(LoginPortal.SCANNER.next())) {
			System.out.println("Data eligible for insertion");
			return true;
		} else {
			LoginPortal.checkKey(user);
			return false;
		}
    }
	
	/**
	 * It validates the mail by routing input to validation.
	 * @param emailStatus
	 * @param user
	 */
	public static void checkEmail(boolean emailStatus, User user) {	

		if(user.getPreferredChoice() == 1) {		
			if(emailStatus) {
				System.out.println("Already exists");
				LoginPortal.signUpAndSignIn(user);
			} 
		} else {
			if(!emailStatus) {
				System.out.println("Reenter EmailId");
				LoginPortal.signUpAndSignIn(user);
			}
		}
	}
	
	/**
	 * It validates the password if the user is logging in.
	 * @param user
	 * @return
	 */
	public static boolean checkPassword(User user) {
		final AuthenticationController authenticationController = new AuthenticationController();
		
		boolean passwordStatus = authenticationController.validatePassword(user.getEmailId(),getPassword());
		
		if(passwordStatus) {
			System.out.println("SignedIn successfully");
			LoginPortal.showProductDetails(user);
			return true;
		} else {
		    System.out.println("Invalid Password.");
		    LoginPortal.signUpAndSignIn(user);
		    return false;
		}
	}
	
	/**
	 * It shows the products available in the database.
	 * @param user
	 */
	public static void showProductDetails(User user) {
		final ProductsController productController = new ProductsController();
		if(user.getTypeOfUser() == 1) {
			AlterProductDetails.getAdminChoice();
		} 
		productController.showProductDetails();
	}
}
