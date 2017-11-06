package com.qyz.dp.state.state;

import com.qyz.dp.state.context.Context;

/**
 * the interface of state, input parameter is target state machine,
 * and return the next state
 * @author simple
 * 2017年11月6日 上午10:29:58
 */
public interface IState {
	
	public IState connect(Context context);
	
	public IState beginToLogin(Context context);
	
	public IState loginFailure(Context context);
	
	public IState loginSuccess(Context context);
	
	public IState logout(Context context);
}
