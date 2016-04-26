package org.apartments.uncc.dao;

import java.sql.SQLException;
import java.util.List;


public interface AdminDao {

	public List<String> listOfOwner() throws SQLException;

}
