package com.heniktechnology.mobile_api.pojo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heniktechnology.mobile_api.constants.Constants;
import com.heniktechnology.mobile_api.constants.Messages;
import com.heniktechnology.mobile_api.pojo.return_type.Return;

@Service
public class UserService {

	@Autowired
	private UserRegisterDao userRegisterDao;

	public Return saveAllUserinDataBase(List<UserRegister> user) {
		try {

			for (UserRegister register : user) {

				userRegisterDao.save(register);
			}

			return new Return(Constants.RESPONSE_STATUS_TRUE, Messages.MESSAGE_SAVE_DATA_SUCCSESSFULLY);

		} catch (Exception e) {
			e.printStackTrace();
			return new Return(Constants.RESPONSE_STATUS_FALSE, e.toString());
		}
	}

	public Return getAllUserFromDataBase() {
		try {

			return new Return(Constants.RESPONSE_STATUS_TRUE, Messages.MESSAGE_GET_DATA_SUCCSESSFULLY,
					userRegisterDao.findAll());

		} catch (Exception e) {
			e.printStackTrace();
			return new Return(Constants.RESPONSE_STATUS_FALSE, e.toString());
		}
	}
}
