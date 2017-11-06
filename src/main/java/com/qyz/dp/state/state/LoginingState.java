package com.qyz.dp.state.state;

import com.qyz.dp.state.context.Context;

public class LoginingState extends AbstractState {

	public LoginingState(StateEnum stateEnum) {
		super(stateEnum);
	}
	@Override
	public IState connect(Context context) {
		throw new RuntimeException("处在登录中");
	}

	@Override
	public IState beginToLogin(Context context) {
		IState nextState = Context.LOGINING_STATE;
		System.out.println(String.format("已经连接并且正在登录，Switch state from %s to %s", context.getState(), nextState));
		return nextState;
	}

	@Override
	public IState loginFailure(Context context) {
		IState nextState = Context.UNCONNECTED_STATE;
		System.out.println(String.format("Switch state from %s to %s", context.getState(), nextState));
		return nextState;
	}

	@Override
	public IState loginSuccess(Context context) {
		IState nextState = Context.LOGIN_INTO_SYSTEM_STATE;
		System.out.println(String.format("Switch state from %s to %s", context.getState(), nextState));
		return nextState;
	}

	@Override
	public IState logout(Context context) {
		throw new RuntimeException("处在登录中");
	}

}
