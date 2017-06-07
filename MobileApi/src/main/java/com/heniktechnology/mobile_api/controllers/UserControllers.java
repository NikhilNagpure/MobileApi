package com.heniktechnology.mobile_api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.heniktechnology.mobile_api.constants.Constants;
import com.heniktechnology.mobile_api.constants.Messages;
import com.heniktechnology.mobile_api.constants.UrlConstants;
import com.heniktechnology.mobile_api.pojo.communication.Request;
import com.heniktechnology.mobile_api.pojo.communication.Response;
import com.heniktechnology.mobile_api.pojo.user.UserRegister;
import com.heniktechnology.mobile_api.pojo.user.UserRegisterDao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class UserControllers {

	@Autowired
	private UserRegisterDao userRegisterDao;
	
	@RequestMapping(method = RequestMethod.POST, value = UrlConstants.USER_REGISTER)
	public Response userRegister(@RequestBody Request request) {
		try {

			System.out.println("request : "+ request.toString());
			List<UserRegister> list = request.getData();
			for (int i = 0; i < list.size(); i++) {
				
				System.out.println("list.get(i) : "+ list.get(i));
				UserRegister register = list.get(i);
				userRegisterDao.save(register);
			}
			
			return new Response(Constants.RESPONCE_CODE_SUCCSESS, Messages.MESSAGE_GET_DATA_SUCCSESS,
					Constants.RESPONCE_STATUS_OK, new ArrayList<>());

		} catch (Exception e) {
			
			e.printStackTrace();
			return new Response(Constants.RESPONCE_CODE_FAIL, e.toString(),
					Constants.RESPONCE_STATUS_FAIL, new ArrayList<>());

		}

		// temp code
	
		
	}

	@RequestMapping(UrlConstants.USER_LOGIN)
	public List<UserRegister> userLogin() {
		return (List<UserRegister>) userRegisterDao.findAll();
	}

	@RequestMapping(UrlConstants.USER_UNREGISTER)
	public String userUnregister() {
		return "userUnRegister";
	}

}
