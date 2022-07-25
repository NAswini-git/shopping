package com.shopping.service;

import com.shopping.dao.AuthenticatorDAO;
import com.shopping.dao.User;

/**
 * It authenticates the type of User with the help of database.
 * @author AswiniN
 *
 */
public class AuthenticatorValidation  {
	private static final AuthenticatorDAO AUTHENTICATOR_DAO = new AuthenticatorDAO();

	/**
	 * To validate EmailId.
	 */
	public boolean validateEmailId(final String emailId) {
		User user = AUTHENTICATOR_DAO.getUserEmailId(emailId);
		
		if (user.getEmailId() == null) {
			return false;
		} 
		return true;		
	}

	/**
	 * To validate Password.
	 */
	public boolean validtePassword(final String emailId, final String password) {
		User user = AUTHENTICATOR_DAO.getUserEmailId(emailId);

		if (user.getPassword().equals(password)) {
			return true;
		} 
		return false;
	}

	/**
	 * To insert data into user table having Email Id and Password.
	 */
	public void insertData(User user) {
		
		if (user.getTypeOfUser() == 1) {
			AUTHENTICATOR_DAO.insertUserData(user,"admin");
		} else {
			AUTHENTICATOR_DAO.insertUserData(user,"user");
		}
	}
}
