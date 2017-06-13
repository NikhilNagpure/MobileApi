package com.heniktechnology.mobile_api.controllers;

import static com.heniktechnology.mobile_api.utill.Logger.log;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.heniktechnology.mobile_api.ApiController;
import com.heniktechnology.mobile_api.constants.Constants;
import com.heniktechnology.mobile_api.constants.Messages;
import com.heniktechnology.mobile_api.constants.UrlConstants;
import com.heniktechnology.mobile_api.pojo.admin.control.AdminControl;
import com.heniktechnology.mobile_api.pojo.communication.HNRequest;
import com.heniktechnology.mobile_api.pojo.communication.HNResponse;

@RestController
public class AdminController {

	private String TAG = AdminController.class.getSimpleName();

	@RequestMapping(method = RequestMethod.POST, value = UrlConstants.ADMIN_CONTROL)
	public HNResponse enableLogger(@RequestBody HNRequest<AdminControl> request) {
		try {

			log(TAG, "request : " + request.toString());

			List<AdminControl> apiControllers = request.getData();

			if (apiControllers != null && apiControllers.size() > 0) {

				if (apiControllers.size() == 0) {
					return new HNResponse(Constants.RESPONSE_CODE_FAIL, Constants.RESPONSE_STATUS_FAIL,
							Messages.MESSAGE_NO_DATA_PASS, new ArrayList<>());
				}
				if (apiControllers.size() > 1) {
					return new HNResponse(Constants.RESPONSE_CODE_FAIL, Constants.RESPONSE_STATUS_FAIL,
							Messages.MESSAGE_MULTIPLE_DATA_IS_NOT_ALLOW, new ArrayList<>());
				}
				if (apiControllers.size() == 1) {

					AdminControl apiController = apiControllers.get(0);

					ApiController.ADMIN_ACTIVE_API = Boolean.valueOf(apiController.getEnableApi());
					
					ApiController.ADMIN_ACTIVE_MESSAGE = apiController.getAdminMessage();
					
					ApiController.ADMIN_ENABLE_LOGGER = Boolean.valueOf(apiController.getEnableLogger());
					
					ApiController.ADMIN_ENABLE_REQUEST_RESPONCE_STORE = Boolean.valueOf(apiController.getRequastResponceStore());

					return new HNResponse(Constants.RESPONSE_CODE_SUCCSESS, Constants.RESPONSE_STATUS_OK,
							Messages.MESSAGE_CHANGES_APPLIED, new ArrayList<>());
					
				}

			} else {
				return new HNResponse(Constants.RESPONSE_CODE_FAIL, Constants.RESPONSE_STATUS_FAIL,
						Messages.MESSAGE_SOMETHING_WENT_WRONG, new ArrayList<>());
			}

		} catch (

		Exception e) {

			e.printStackTrace();
			return new HNResponse(Constants.RESPONSE_CODE_FAIL, Constants.RESPONSE_STATUS_FAIL, e.toString(),
					new ArrayList<>());

		}

		return null;

	}

}
