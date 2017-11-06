package com.qyz.dp.state.state;

import com.qyz.dp.state.context.Context;

public class LoginIntoSystem implements IState {

	@Override
	public IState connect(Context context) {
		throw new RuntimeException("已经登录进系统");

	}

	@Override
	public IState beginToLogin(Context context) {
		throw new RuntimeException("已经登录进系统");

	}

	@Override
	public IState loginFailure(Context context) {
		throw new RuntimeException("已经登录进系统");

	}

	@Override
	public IState loginSuccess(Context context) {
		IState nextState = Context.LOGIN_INTO_SYSTEM_STATE;
		System.out.println(String.format("已经登录进系统了，Switch state from %s to %s", context.getState(), nextState));
		return nextState;
	}

	@Override
	public IState logout(Context context) {
		IState nextState = Context.UNCONNECTED_STATE;
		System.out.println(String.format("Switch state from %s to %s", context.getState(), nextState));
		return nextState;
	}

}
