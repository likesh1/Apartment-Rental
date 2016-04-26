/**
 * 
 */
package org.apartments.uncc.utilities.impl;

import java.io.File;

import org.apartments.uncc.dao.ApartmentDao;
import org.apartments.uncc.utilities.IFilePath;

/**
 * @author Pritam
 *
 */
public class FilePathLocator implements IFilePath {

	/* (non-Javadoc)
	 * @see org.apartments.uncc.utilities.IFilePath#getFileUploadPath(java.lang.String)
	 */
	private ApartmentDao apartmentDao;
	public ApartmentDao getApartmentDao() {
		return apartmentDao;
	}
	public void setApartmentDao(ApartmentDao apartmentDao) {
		this.apartmentDao = apartmentDao;
	}
	@Override
	public String getFileUploadPath(String aptId) {
		// TODO Auto-generated method stub
		int ownerId=apartmentDao.getOwnerId(Integer.parseInt(aptId));
		String rootPath = System.getProperty("catalina.home");
		 return rootPath+ File.separator + ownerId+File.separator+aptId;
		
		//return null;
	}
	@Override
	public String getImagePath(int aptId) {
		// TODO Auto-generated method stub
		int ownerId=apartmentDao.getOwnerId(aptId);
		//String rootPath = System.getProperty("catalina.home");
		 return ownerId+File.separator+aptId+File.separator;
	}

}
