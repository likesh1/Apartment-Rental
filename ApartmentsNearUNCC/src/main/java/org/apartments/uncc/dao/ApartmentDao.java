/**
 * 
 */
package org.apartments.uncc.dao;

import java.util.List;

import org.apartments.uncc.viewBeans.ApartmentDetailsBean;

/**
 * @author Pritam
 *
 */
public interface ApartmentDao {
	public List<ApartmentDetailsBean> getApartmentList(String location);
}
