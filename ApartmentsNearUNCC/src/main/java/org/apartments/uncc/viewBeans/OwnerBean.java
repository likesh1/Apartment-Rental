/**
 * 
 */
package org.apartments.uncc.viewBeans;

/**
 * @author Pritam
 *
 */
public class OwnerBean {

	private int ownerId;
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	private String oFirstName;
	private String oLastName;
	private String oEmail;
	private long oPhoneNo;
	private String oPassword;
	
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
