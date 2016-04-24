/**
 * 
 */
package org.apartments.uncc.service;

import java.util.List;
import java.util.Map;

import org.apartments.uncc.viewBeans.ApartmentDetailsBean;

/**
 * @author Pritam
 *
 */
public interface ApartmentService {

	List<ApartmentDetailsBean> getApartmentList(String location);
	public Map getApartmentDetails(int id);
	List<ApartmentDetailsBean> getMyApartments(String emailId);
	
}
