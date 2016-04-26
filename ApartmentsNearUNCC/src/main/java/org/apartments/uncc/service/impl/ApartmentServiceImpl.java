/**
 * 
 */
package org.apartments.uncc.service.impl;

import java.util.List;
import java.util.Map;

import org.apartments.uncc.dao.ApartmentDao;
import org.apartments.uncc.dao.UserDao;
import org.apartments.uncc.service.ApartmentService;
import org.apartments.uncc.utilities.IFilePath;
import org.apartments.uncc.utilities.IFileUploader;
import org.apartments.uncc.viewBeans.ApartmentDetailsBean;
import org.apartments.uncc.viewBeans.TenantBean;
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
	private IFilePath filePath;
	
	
	public IFilePath getFilePath() {
		return filePath;
	}


	public void setFilePath(IFilePath filePath) {
		this.filePath = filePath;
	}


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


	@Override
	public void addTenant(String aptId, TenantBean newTenant) {
		// TODO Auto-generated method stub
		apartmentDao.addTenant(aptId,newTenant);
	}


	@Override
	public String getImagePath(int aptId) {
		// TODO Auto-generated method stub
		return filePath.getImagePath(aptId);
	}


	@Override
	public List<TenantBean> getTenants(int aptId) {
		// TODO Auto-generated method stub
		return apartmentDao.getTenants(aptId);
	}


	@Override
	public void updateTenant(int aptId,TenantBean tenant) {
		// TODO Auto-generated method stub
		apartmentDao.updateTenant(aptId,tenant);
	}

}
