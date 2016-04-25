/**
 * 
 */
package org.apartments.uncc.delegate;

import org.apartments.uncc.service.ApartmentService;
import org.apartments.uncc.viewBeans.ApartmentDetailsBean;

/**
 * @author Pritam
 *
 */
public class OwnerDelegate {
	private ApartmentService apartmentService;
	public ApartmentService getApartmentService() {
		return apartmentService;
	}


	public void setApartmentService(ApartmentService apartmentService) {
		this.apartmentService = apartmentService;
	}


	public int getNewApartmentId(ApartmentDetailsBean aptDetails,String email) {
		// TODO Auto-generated method stub
		return apartmentService.getNewApartmentId(aptDetails,email);
	}

}
