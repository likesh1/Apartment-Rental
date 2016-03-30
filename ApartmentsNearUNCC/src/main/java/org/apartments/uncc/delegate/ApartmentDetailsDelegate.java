/**
 * 
 */
package org.apartments.uncc.delegate;

import java.util.List;
import java.util.Map;

import org.apartments.uncc.service.ApartmentService;
import org.apartments.uncc.viewBeans.ApartmentDetailsBean;

/**
 * @author Pritam
 *
 */
public class ApartmentDetailsDelegate {

	private ApartmentService apartmentService;
	
	public ApartmentService getApartmentService() {
		return apartmentService;
	}

	public void setApartmentService(ApartmentService apartmentService) {
		this.apartmentService = apartmentService;
	}

	public Map getApartmentDetails(String id) {
		// TODO Auto-generated method stub
		return apartmentService.getApartmentDetails(Integer.parseInt(id));
	}

}
