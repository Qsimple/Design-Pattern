package com.qyz.dp.state.state;

import com.qyz.dp.state.context.Context;

public class UnconnectedState extends AbstractState{

	@Override
	public IState connect(Context context) {
		IState nextState = StateEnum.CONNECTED.getState();
		System.out.println(String.format("Switch state from %s to %s", context.getState(), nextState));
		return nextState;
	}

	@Override
	public IState beginToLogin(Context context) {
		throw new RuntimeException("还没有连接，不能登录");
		
	}

	@Override
	public IState loginFailure(Context context) {
		throw new RuntimeException("还没有连接，不能登录");
	}

	@Override
	public IState loginSuccess(Context context) {
		throw new RuntimeException("还没有连接，不能登录");
	}

	@Override
	public IState logout(Context context) {
		throw new RuntimeException("还没有连接，不能登录");
	}

}
