/**
 * 
 */
package org.apartments.uncc.viewBeans;

import java.sql.Date;

/**
 * @author Pritam
 *
 */
public class TenantBean {
	private int tenantId;
	private int apartmentId;
	private String tfirstName;
	private String tlastName;
	private String tEmail;
	private String tgender;
	private int tage;
	private Date tBOD;
	private String Eating_pref;
	private String nationality;
	private String Visa_status;
	private String degree;
	private String major;
	private String tPhoneNo;
	private String tPassword;
	public int getTenantId() {
		return tenantId;
	}
	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}
	public int getApartmentId() {
		return apartmentId;
	}
	public void setApartmentId(int apartmentId) {
		this.apartmentId = apartmentId;
	}
	public String getTfirstName() {
		return tfirstName;
	}
	public void setTfirstName(String tfirstName) {
		this.tfirstName = tfirstName;
	}
	public String getTlastName() {
		return tlastName;
	}
	public void setTlastName(String tlastName) {
		this.tlastName = tlastName;
	}
	public String gettEmail() {
		return tEmail;
	}
	public void settEmail(String tEmail) {
		this.tEmail = tEmail;
	}
	public String getTgender() {
		return tgender;
	}
	public void setTgender(String tgender) {
		this.tgender = tgender;
	}
	public int getTage() {
		return tage;
	}
	public void setTage(int tage) {
		this.tage = tage;
	}
	public Date gettBOD() {
		return tBOD;
	}
	public void settBOD(Date tBOD) {
		this.tBOD = tBOD;
	}
	public String getEating_pref() {
		return Eating_pref;
	}
	public void setEating_pref(String eating_pref) {
		Eating_pref = eating_pref;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getVisa_status() {
		return Visa_status;
	}
	public void setVisa_status(String visa_status) {
		Visa_status = visa_status;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String gettPhoneNo() {
		return tPhoneNo;
	}
	public void settPhoneNo(String tPhoneNo) {
		this.tPhoneNo = tPhoneNo;
	}
	public String gettPassword() {
		return tPassword;
	}
	public void settPassword(String tPassword) {
		this.tPassword = tPassword;
	}

}
