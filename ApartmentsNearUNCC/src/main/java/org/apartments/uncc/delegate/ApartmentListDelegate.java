/**
 * 
 */
package org.apartments.uncc.delegate;

import java.sql.SQLException;
import java.util.List;

import org.apartments.uncc.exceptions.InvalidEmailIdException;
import org.apartments.uncc.service.ApartmentService;
import org.apartments.uncc.viewBeans.ApartmentDetailsBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Pritam
 *
 */
public class ApartmentListDelegate {
	
	private ApartmentService apartmentService;

	public ApartmentService getApartmentService() {
		return apartmentService;
	}

	public void setApartmentService(ApartmentService apartmentService) {
		this.apartmentService = apartmentService;
	}
	
	public List<ApartmentDetailsBean> getApartmentList(String location) throws SQLException
	{
	     return apartmentService.getApartmentList(location);
	}
}
