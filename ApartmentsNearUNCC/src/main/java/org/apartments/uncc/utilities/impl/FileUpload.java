/**
 * 
 */
package org.apartments.uncc.utilities.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.apartments.uncc.controllers.ApartmentController;
import org.apartments.uncc.utilities.IFilePath;
import org.apartments.uncc.utilities.IFileUploader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(FileUpload.class);
	public IFilePath getFilePath() {
		return filePath;
	}

	public void setFilePath(IFilePath filePath) {
		this.filePath = filePath;
	}

	@Override
	public void uploadFile(String aptId, String[] names, MultipartFile[] files) {
		// TODO Auto-generated method stub
		String folderPath= filePath.getFileUploadPath(aptId);
		String message = "";
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			String name = names[i];
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				File dir = new File(folderPath);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());

				message = message + "You successfully uploaded file=" + name
						+ "<br />";
			} catch (Exception e) {
				System.out.println(e.getMessage());
				//return "You failed to upload " + name + " => " + e.getMessage();
			}
		}
	}

}
