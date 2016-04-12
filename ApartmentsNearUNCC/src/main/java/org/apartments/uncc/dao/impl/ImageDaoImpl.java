/**
 * 
 */
package org.apartments.uncc.dao.impl;

import javax.sql.DataSource;

import org.apartments.uncc.dao.ImageDao;

/**
 * @author Pritam
 *
 */
public class ImageDaoImpl implements ImageDao {
	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
