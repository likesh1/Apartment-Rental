/**
 * 
 */
package org.apartments.uncc.dao;

import java.util.List;
import java.util.Map;

import org.apartments.uncc.viewBeans.ApartmentDetailsBean;
import org.apartments.uncc.viewBeans.TenantBean;

/**
 * @author Pritam
 *
 */
public interface ApartmentDao {
	public List<ApartmentDetailsBean> getApartmentList(String location);
	public Map getApartmentDetails(int id);
	public List<ApartmentDetailsBean> getApartmentDetails(String emailId);
	public int getNewApartmentId(ApartmentDetailsBean aptDetails,String email);
	public int getOwnerId(int aptId);
	public void addTenant(String aptId, TenantBean newTenant);
	public List<TenantBean> getTenants(int aptId);
	public void updateTenant(int aptId, TenantBean tenant);
	public void updateApartment(ApartmentDetailsBean aptUpdated);
}
