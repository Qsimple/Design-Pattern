package com.qyz.dp.state.state;

import com.qyz.dp.state.context.Context;

public class ConnectedState implements IState {

	@Override
	public IState connect(Context context) {
		IState nextState = Context.CONNECTED_STATE;
		System.out.println(String.format("已经连接了，Switch state from %s to %s", context.getState(), nextState));
		return nextState;
	}

	@Override
	public IState beginToLogin(Context context) {
		IState nextState = Context.LOGINING_STATE;
		System.out.println(String.format("Switch state from %s to %s", context.getState(), nextState));
		return nextState;
	}

	@Override
	public IState loginFailure(Context context) {
		throw new RuntimeException("不是正在登录状态");
	}

	@Override
	public IState loginSuccess(Context context) {
		throw new RuntimeException("不是正在登录状态");
	}

	@Override
	public IState logout(Context context) {
		throw new RuntimeException("不是正在登录状态");
	}

}
