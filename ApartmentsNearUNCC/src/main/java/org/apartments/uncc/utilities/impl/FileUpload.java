/**
 * 
 */
package org.apartments.uncc.utilities.impl;

import org.apartments.uncc.utilities.IFilePath;
import org.apartments.uncc.utilities.IFileUploader;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Pritam
 *
 */
public class FileUpload implements IFileUploader {

	/* (non-Javadoc)
	 * @see org.apartments.uncc.utilities.IFileUploader#uploadFile(java.lang.String, java.lang.String[], org.springframework.web.multipart.MultipartFile[])
	 */
	private IFilePath filePath;
	
	public IFilePath getFilePath() {
		return filePath;
	}

	public void setFilePath(IFilePath filePath) {
		this.filePath = filePath;
	}

	@Override
	public void uploadFile(String aptId, String[] names, MultipartFile[] files) {
		// TODO Auto-generated method stub
		
	}

}
