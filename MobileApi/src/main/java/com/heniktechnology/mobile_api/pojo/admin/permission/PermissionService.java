package com.heniktechnology.mobile_api.pojo.admin.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heniktechnology.mobile_api.constants.Constants;
import com.heniktechnology.mobile_api.constants.Messages;
import com.heniktechnology.mobile_api.pojo.return_type.Return;
import com.heniktechnology.mobile_api.pojo.user.UserRegister;

@Service
public class PermissionService {
	
	@Autowired 
	public PermissionDao permissionDao;
	
	
	public Return addPermission(Permission  permission)
	{
		try {
			
			permissionDao.save(permission);
		
			return new Return(Constants.RESPONSE_STATUS_TRUE, Messages.MESSAGE_SAVE_DATA_SUCCSESSFULLY);

		} catch (Exception e) {
			e.printStackTrace();
			return new Return(Constants.RESPONSE_STATUS_FALSE, e.toString());
		}
	}
	
	
	public Return removePermission(Permission permission)
	{
		try {
			
			permissionDao.delete(permission);
		
			return new Return(Constants.RESPONSE_STATUS_TRUE, Messages.MESSAGE_REMOVE_DATA_SUCCSESSFULLY);

		} catch (Exception e) {
			e.printStackTrace();
			return new Return(Constants.RESPONSE_STATUS_FALSE, e.toString());
		}
	}
	

}
