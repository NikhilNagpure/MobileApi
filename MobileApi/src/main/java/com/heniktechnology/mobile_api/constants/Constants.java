package com.heniktechnology.mobile_api.constants;

import java.util.Arrays;
import java.util.List;

import com.heniktechnology.mobile_api.pojo.admin.Admin;
import com.heniktechnology.mobile_api.pojo.admin.permission.Permission;

public class Constants {

	// response code
	public static final String RESPONSE_CODE_SUCCSESS = "100";

	public static final String RESPONSE_CODE_FAIL = "101";

	public static final String RESPONSE_STATUS_OK = "OK";

	public static final String RESPONSE_STATUS_FAIL = "FAIL";

	// Active
	public static final String ACTIVE_TRUE = "true";

	public static final String ACTIVE_FALSE = "false";

	// internal Response
	public static final boolean RESPONSE_STATUS_TRUE = true;

	public static final boolean RESPONSE_STATUS_FALSE = false;

	// Permission
	public static final String PERMISSION_READ_API = "readApi";

	public static final String PERMISSION_START_API = "StartApi";

	public static final String PERMISSION_STOP_API = "StopApi";

	public static final String PERMISSION_ADD_ADMIN = "addAdmin";

	public static final String PERMISSION_REMOVE_ADMIN = "removeAdmin";

	public static final List<Permission> PERMISSION_LIST = Arrays.asList(new Permission(PERMISSION_READ_API),
			new Permission(PERMISSION_START_API), new Permission(PERMISSION_STOP_API),
			new Permission(PERMISSION_ADD_ADMIN), new Permission(PERMISSION_REMOVE_ADMIN));

	// default Admin

	public static final String ADMIN_NAME = "NIKHIL";

	public static final String ADMIN_LOGIN_ID = "nikhilnagpure";

	public static final String ADMIN_PASSWORD = "nikhilnagpure";

	public static final String ADMIN_NOTES = "defaultAdmin";

	public static final Admin ADMIN = new Admin( ADMIN_NAME, ADMIN_LOGIN_ID, ADMIN_PASSWORD, ADMIN_NOTES, PERMISSION_LIST);

}
