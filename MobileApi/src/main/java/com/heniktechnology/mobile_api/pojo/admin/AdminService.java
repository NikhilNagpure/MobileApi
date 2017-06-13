package com.heniktechnology.mobile_api.pojo.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heniktechnology.mobile_api.constants.Constants;
import com.heniktechnology.mobile_api.constants.Messages;
import com.heniktechnology.mobile_api.pojo.return_type.Return;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao adminDao;

	public void getAnliticalInfo(Admin admin)
	{
		
	}
	
	public void activeApi(Admin admin)
	{
		
	}
	
	public Return addAdmin(Admin admin)
	{
		try {

			adminDao.save(admin);
			
			return new Return(Constants.RESPONSE_STATUS_TRUE, Messages.MESSAGE_SAVE_DATA_SUCCSESSFULLY);

		} catch (Exception e) {
			e.printStackTrace();
			return new Return(Constants.RESPONSE_STATUS_FALSE, e.toString());
		}
		
	}
	
	public void removeAdmin(Admin admin)
	{
		
	}
	
	public void removeAdminPermission(Admin admin)
	{
		
	}
	
	public void addAdminPermission(Admin admin)
	{
		
	}
	
	public void getAdminPermission(Admin admin)
	{
		
	}
	

}
