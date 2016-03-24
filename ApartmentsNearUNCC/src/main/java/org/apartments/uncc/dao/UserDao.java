package org.apartments.uncc.dao;

import java.sql.SQLException;

/**
 * @author Pritam Borate
 * This interface will be used to communicate with the
 * Database
 */
public interface UserDao
{
		public boolean isValidUser(String username, String password) throws SQLException;
}
