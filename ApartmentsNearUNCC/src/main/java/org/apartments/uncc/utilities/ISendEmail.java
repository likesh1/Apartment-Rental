/**
 * 
 */
package org.apartments.uncc.utilities;

import org.apartments.uncc.viewBeans.UserDetailsBean;

/**
 * @author Pritam
 *
 */
public interface ISendEmail {
	public void sendEmail(UserDetailsBean userDetails);
	//public int sendVerificationCode();
}
