/**
 * 
 */
package org.apartments.uncc.utilities;

import org.apartments.uncc.viewBeans.MailBean;
import org.apartments.uncc.viewBeans.UserDetailsBean;

/**
 * @author Pritam
 *
 */
public interface ISendEmail {
	public void sendEmail(UserDetailsBean userDetails);
	public void sendEmail(MailBean mailBean);
	//public int sendVerificationCode();
}
