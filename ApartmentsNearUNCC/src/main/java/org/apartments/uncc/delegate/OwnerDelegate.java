/**
 * 
 */
package org.apartments.uncc.delegate;

import org.apartments.uncc.service.ApartmentService;
import org.apartments.uncc.viewBeans.ApartmentDetailsBean;
import org.apartments.uncc.viewBeans.TenantBean;
import org.springframework.web.multipart.MultipartFile;

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


	public void uploadFile(String aptId, String[] names, MultipartFile[] files) {
		// TODO Auto-generated method stub
		apartmentService.uploadFile(aptId,names,files);
	}


	public void addTenant(String aptId, TenantBean newTenant) {
		// TODO Auto-generated method stub
		apartmentService.addTenant(aptId,newTenant);
	}

}
