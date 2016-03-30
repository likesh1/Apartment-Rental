/**
 * 
 */
package org.apartments.uncc.viewBeans;

/**
 * @author Pritam
 *
 */
public class OwnerBean {

	private int oSSN;
	private String oFirstName;
	private String oLastName;
	private String oEmail;
	private long oPhoneNo;
	private String oPassword;
	public int getoSSN() {
		return oSSN;
	}
	public void setoSSN(int oSSN) {
		this.oSSN = oSSN;
	}
	public String getoFirstName() {
		return oFirstName;
	}
	public void setoFirstName(String oFirstName) {
		this.oFirstName = oFirstName;
	}
	public String getoLastName() {
		return oLastName;
	}
	public void setoLastName(String oLastName) {
		this.oLastName = oLastName;
	}
	public String getoEmail() {
		return oEmail;
	}
	public void setoEmail(String oEmail) {
		this.oEmail = oEmail;
	}
	public long getoPhoneNo() {
		return oPhoneNo;
	}
	public void setoPhoneNo(long l) {
		this.oPhoneNo = l;
	}
	public String getoPassword() {
		return oPassword;
	}
	public void setoPassword(String oPassword) {
		this.oPassword = oPassword;
	}
}
