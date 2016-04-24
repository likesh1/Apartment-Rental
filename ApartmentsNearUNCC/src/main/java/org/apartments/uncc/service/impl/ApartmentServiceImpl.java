/**
 * 
 */
package org.apartments.uncc.service.impl;

import java.util.List;
import java.util.Map;

import org.apartments.uncc.dao.ApartmentDao;
import org.apartments.uncc.dao.UserDao;
import org.apartments.uncc.service.ApartmentService;
import org.apartments.uncc.viewBeans.ApartmentDetailsBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Pritam
 *
 */
public class ApartmentServiceImpl implements ApartmentService {

	/* (non-Javadoc)
	 * @see org.apartments.uncc.service.ApartmentService#getApartmentList()
	 */
	
	private ApartmentDao apartmentDao;
	
	
	public ApartmentDao getApartmentDao() {
		return apartmentDao;
	}


	public void setApartmentDao(ApartmentDao apartmentDao) {
		this.apartmentDao = apartmentDao;
	}


	@Override
	public List<ApartmentDetailsBean> getApartmentList(String location) {
		// TODO Auto-generated method stub
		return apartmentDao.getApartmentList(location);
	}


	@Override
	public Map getApartmentDetails(int id) {
		// TODO Auto-generated method stub
		return apartmentDao.getApartmentDetails(id);
	}


	@Override
	public List<ApartmentDetailsBean> getMyApartments(String emailId) {
		// TODO Auto-generated method stub
		return apartmentDao.getApartmentDetails(emailId);
	}

}
