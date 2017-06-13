package com.heniktechnology.mobile_api.pojo.api_observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heniktechnology.mobile_api.constants.Constants;
import com.heniktechnology.mobile_api.constants.Messages;
import com.heniktechnology.mobile_api.pojo.return_type.Return;

@Service
public class ApiTransactionsService {

	@Autowired
	private ApiTransactionsDao apiTransactionsDao;
	

	public Return saveApiTransactionsinDataBase(ApiTransactions apiTransactions) {
		try {

			apiTransactionsDao.save(apiTransactions);

			return new Return(Constants.RESPONSE_STATUS_TRUE, Messages.MESSAGE_SAVE_DATA_SUCCSESSFULLY);

		} catch (Exception e) {
			e.printStackTrace();
			return new Return(Constants.RESPONSE_STATUS_FALSE, e.toString());
		}
	}

	public Return getAllApiTransactionsFormDataBase() {
		try {

			return new Return(Constants.RESPONSE_STATUS_TRUE, Messages.MESSAGE_GET_DATA_SUCCSESSFULLY,
					apiTransactionsDao.findAll());

		} catch (Exception e) {
			e.printStackTrace();
			return new Return(Constants.RESPONSE_STATUS_FALSE, e.toString());
		}
	}

}
