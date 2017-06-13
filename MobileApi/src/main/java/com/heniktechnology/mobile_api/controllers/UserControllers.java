package com.heniktechnology.mobile_api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.heniktechnology.mobile_api.ApiController;
import com.heniktechnology.mobile_api.constants.Constants;
import com.heniktechnology.mobile_api.constants.Messages;
import com.heniktechnology.mobile_api.constants.UrlConstants;
import com.heniktechnology.mobile_api.pojo.communication.HNRequest;
import com.heniktechnology.mobile_api.pojo.communication.HNResponse;
import com.heniktechnology.mobile_api.pojo.return_type.Return;
import com.heniktechnology.mobile_api.pojo.user.UserRegister;
import com.heniktechnology.mobile_api.pojo.user.UserRegisterDao;
import com.heniktechnology.mobile_api.pojo.user.UserService;

import static com.heniktechnology.mobile_api.utill.Logger.*;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class UserControllers {

	private String TAG = UserControllers.class.getSimpleName();

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = UrlConstants.USER_REGISTER)
	public HNResponse userRegister(@RequestBody HNRequest<UserRegister> request) {
		try {

			if (ApiController.ADMIN_ACTIVE_API) {

				log(TAG, "request : " + request.toString());

				Return returnValue = userService.saveAllUserinDataBase(request.getData());

				if (returnValue.isSuccsess()) {

					return new HNResponse(Constants.RESPONSE_CODE_SUCCSESS, Constants.RESPONSE_STATUS_OK,
							returnValue.getMessage(), new ArrayList<>());

				} else {

					return new HNResponse(Constants.RESPONSE_CODE_FAIL, Constants.RESPONSE_STATUS_FAIL,
							returnValue.getMessage(), new ArrayList<>());
				}

			} else {
				return new HNResponse(Constants.RESPONSE_CODE_FAIL, Constants.RESPONSE_STATUS_FAIL,
						ApiController.ADMIN_ACTIVE_MESSAGE, new ArrayList<>());
			}

		} catch (Exception e) {

			e.printStackTrace();
			return new HNResponse(Constants.RESPONSE_CODE_FAIL, Constants.RESPONSE_STATUS_FAIL, e.toString(),
					new ArrayList<>());

		}

	}

	@RequestMapping(UrlConstants.USER_LOGIN)
	public HNResponse userLogin() {
		try
		{
			if (ApiController.ADMIN_ACTIVE_API) {
				
				Return returnValue = userService.getAllUserFromDataBase();
				if (returnValue.isSuccsess()) {
					return new HNResponse(Constants.RESPONSE_CODE_SUCCSESS, Constants.RESPONSE_STATUS_OK,
							returnValue.getMessage(), (List<UserRegister>) returnValue.getObject());
				} else {
					return new HNResponse(Constants.RESPONSE_CODE_FAIL, Constants.RESPONSE_STATUS_FAIL,
							returnValue.getMessage(), new ArrayList<UserRegister>());
				}
				
			} else {
				return new HNResponse(Constants.RESPONSE_CODE_FAIL, Constants.RESPONSE_STATUS_FAIL,
						ApiController.ADMIN_ACTIVE_MESSAGE, new ArrayList<>());
			}
		}catch (Exception e) {

			e.printStackTrace();
			return new HNResponse(Constants.RESPONSE_CODE_FAIL, Constants.RESPONSE_STATUS_FAIL, e.toString(),
					new ArrayList<>());

		}

	}

	@RequestMapping(method = RequestMethod.DELETE, value = UrlConstants.USER_LOGIN)
	public HNResponse userUnregister(@RequestBody UserRegister register) {
		try {
			
			
			return new HNResponse();
			
		} catch (Exception e) {
			e.printStackTrace();
			return new HNResponse(Constants.RESPONSE_CODE_FAIL, Constants.RESPONSE_STATUS_FAIL, e.toString(),
					new ArrayList<>());

		}
	}

}
