/**
 * 
 */
package org.apartments.uncc.utilities.impl;

import org.apartments.uncc.utilities.ICodeGenerator;

/**
 * @author Pritam
 *
 */
public class CodeGeneratorImpl implements ICodeGenerator {

	/* (non-Javadoc)
	 * @see org.apartments.uncc.utilities.ICodeGenerator#getVerificationCode()
	 */
	@Override
	public int getVerificationCode() {
		// TODO Auto-generated method stub
		return (int) (Math.round(Math.random() * 89999) + 10000);
	}

}
