/**
 * 
 */
package org.apartments.uncc.service;

import java.util.List;

import org.apartments.uncc.viewBeans.ApartmentDetailsBean;

/**
 * @author Pritam
 *
 */
public interface ApartmentService {

	List<ApartmentDetailsBean> getApartmentList();
	
}
