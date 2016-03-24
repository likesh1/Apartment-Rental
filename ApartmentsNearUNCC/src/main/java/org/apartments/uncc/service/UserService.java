/**
 * 
 */
package org.apartments.uncc.service;

import java.sql.SQLException;

/**
 * @author Pritam
 *
 */
public interface UserService {
	public boolean isValidUser(String username, String password) throws SQLException;
}
