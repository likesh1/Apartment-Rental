/**
 * 
 */
package org.apartments.uncc.service.impl;

import java.util.List;
import java.util.Map;

import org.apartments.uncc.dao.ApartmentDao;
import org.apartments.uncc.dao.UserDao;
import org.apartments.uncc.service.ApartmentService;
import org.apartments.uncc.utilities.IFileUploader;
import org.apartments.uncc.viewBeans.ApartmentDetailsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Pritam
 *
 */
public class ApartmentServiceImpl implements ApartmentService {

	/* (non-Javadoc)
	 * @see org.apartments.uncc.service.ApartmentService#getApartmentList()
	 */
	
	private ApartmentDao apartmentDao;
	private IFileUploader fileUploader;
	
	
	public IFileUploader getFileUploader() {
		return fileUploader;
	}


	public void setFileUploader(IFileUploader fileUploader) {
		this.fileUploader = fileUploader;
	}


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


	@Override
	public int getNewApartmentId(ApartmentDetailsBean aptDetails,String email) {
		// TODO Auto-generated method stub
		return apartmentDao.getNewApartmentId(aptDetails,email);
	}


	@Override
	public void uploadFile(String aptId, String[] names, MultipartFile[] files) {
		// TODO Auto-generated method stub
		fileUploader.uploadFile(aptId, names, files);
	}

}
