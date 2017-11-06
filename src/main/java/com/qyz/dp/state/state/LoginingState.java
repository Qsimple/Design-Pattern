package com.qyz.dp.state.state;

import com.qyz.dp.state.context.Context;

public class LoginingState extends AbstractState {

	@Override
	public IState connect(Context context) {
		throw new RuntimeException("处在登录中");
	}

	@Override
	public IState beginToLogin(Context context) {
		IState nextState = StateEnum.LOGINING.getState();
		System.out.println(String.format("已经连接并且正在登录，Switch state from %s to %s", context.getState(), nextState));
		return nextState;
	}

	@Override
	public IState loginFailure(Context context) {
		IState nextState = StateEnum.UNCONNECTED.getState();
		System.out.println(String.format("Switch state from %s to %s", context.getState(), nextState));
		return nextState;
	}

	@Override
	public IState loginSuccess(Context context) {
		IState nextState = StateEnum.LOGIN_INTO_SYSTEM.getState();
		System.out.println(String.format("Switch state from %s to %s", context.getState(), nextState));
		return nextState;
	}

	@Override
	public IState logout(Context context) {
		throw new RuntimeException("处在登录中");
	}

}
