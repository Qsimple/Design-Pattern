package com.qyz.dp.state.client;

import com.qyz.dp.state.context.Context;
import com.qyz.dp.state.state.StateEnum;

public class Client {

	public static void main(String[] args) {
		
		Context context = new Context(StateEnum.UNCONNECTED);
		
		context.connect();
		context.beginToLogin();
		context.loginFailure();
		context.connect();
		context.beginToLogin();
		context.loginSuccess();
		context.logout();

	}

}
