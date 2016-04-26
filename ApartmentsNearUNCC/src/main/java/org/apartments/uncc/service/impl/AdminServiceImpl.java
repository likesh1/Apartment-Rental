package org.apartments.uncc.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apartments.uncc.dao.AdminDao;
import org.apartments.uncc.service.AdminService;

public class AdminServiceImpl implements AdminService {


	private AdminDao adminDao;

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	@Override
	public List<String> listOfOwner() throws SQLException {
		// TODO Auto-generated method stub
		return adminDao.listOfOwner();
	}

}
