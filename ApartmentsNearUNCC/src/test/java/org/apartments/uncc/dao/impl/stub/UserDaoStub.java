/**
 * 
 */
package org.apartments.uncc.dao.impl.stub;

import java.sql.SQLException;

import org.apartments.uncc.exceptions.InvalidEmailIdException;
import org.apartments.uncc.viewBeans.RegistrationBean;

/**
 * @author Pritam
 *
 */
public interface UserDaoStub {
	public boolean isValidUser(String username, String password) throws SQLException;

	public boolean isValidRegistration(RegistrationBean registratinBean)throws SQLException, InvalidEmailIdException;

}
