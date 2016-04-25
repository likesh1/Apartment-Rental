/**
 * 
 */
package org.apartments.uncc.utilities;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Pritam
 *
 */
public interface IFileUploader {

	void uploadFile(String aptId, String[] names, MultipartFile[] files);

}
