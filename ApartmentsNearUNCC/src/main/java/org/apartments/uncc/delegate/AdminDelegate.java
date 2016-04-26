package org.apartments.uncc.delegate;

import java.sql.SQLException;
import java.util.List;

import org.apartments.uncc.service.AdminService;

public class AdminDelegate {
	
	private AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public List<String> getListOfOwner() throws SQLException {
		// TODO Auto-generated method stub
		return adminService.listOfOwner();
	}
	
	public boolean makeOwnerActive(String email) {
		
		return adminService.makeOwnerActive(email);
		
	}

}
