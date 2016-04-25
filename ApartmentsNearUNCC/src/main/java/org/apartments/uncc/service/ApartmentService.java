/**
 * 
 */
package org.apartments.uncc.service;

import java.util.List;
import java.util.Map;

import org.apartments.uncc.viewBeans.ApartmentDetailsBean;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Pritam
 *
 */
public interface ApartmentService {

	List<ApartmentDetailsBean> getApartmentList(String location);
	public Map getApartmentDetails(int id);
	List<ApartmentDetailsBean> getMyApartments(String emailId);
	int getNewApartmentId(ApartmentDetailsBean aptDetails,String email);
	void uploadFile(String aptId, String[] names, MultipartFile[] files);
	
}
