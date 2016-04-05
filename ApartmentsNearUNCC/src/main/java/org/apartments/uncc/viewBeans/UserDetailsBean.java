/**
 * 
 */
package org.apartments.uncc.viewBeans;

/**
 * @author Pritam
 *
 */
public class UserDetailsBean {
	private String fName;
	private String username;
	private String userRole;
	private int verificationCode;
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public int getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(int i) {
		this.verificationCode = i;
	}
}
