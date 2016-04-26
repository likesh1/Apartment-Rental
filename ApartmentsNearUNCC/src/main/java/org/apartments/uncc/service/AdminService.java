package org.apartments.uncc.service;

import java.sql.SQLException;
import java.util.List;

public interface AdminService {

	public List<String> listOfOwner() throws SQLException;

}
