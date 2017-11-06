package com.qyz.dp.state.client;

import com.qyz.dp.state.context.Context;

public class Client {

	public static void main(String[] args) {
		
		Context context = new Context(Context.UNCONNECTED_STATE);
		
		context.connect();
		context.beginToLogin();
		context.loginFailure();
		context.connect();
		context.beginToLogin();
		context.loginSuccess();
		context.logout();

	}

}
