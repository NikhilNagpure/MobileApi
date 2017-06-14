package com.heniktechnology.mobile_api;

import static com.heniktechnology.mobile_api.utill.Logger.log;
import org.springframework.beans.factory.annotation.Autowired;
import com.heniktechnology.mobile_api.constants.Constants;
import com.heniktechnology.mobile_api.pojo.admin.AdminService;
import com.heniktechnology.mobile_api.pojo.admin.permission.PermissionService;

public class BasicInitializer {

	private String TAG = BasicInitializer.class.getSimpleName();

	@Autowired
	private PermissionService permissionService;

	@Autowired
	private AdminService adminService;

	
	public void insertValuInDataBase() {

		/*
		 * for (int i = 0; i < Constants.PERMISSION_LIST.size(); i++) {
		 * 
		 * permissionService.addPermission(new
		 * Permission(Constants.PERMISSION_LIST.get(i))); }
		 */

		log(TAG, Constants.ADMIN.toString());

		adminService.addAdmin(Constants.ADMIN);

	}

}
