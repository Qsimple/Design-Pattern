package com.qyz.dp.state.context;

import com.qyz.dp.state.state.ConnectedState;
import com.qyz.dp.state.state.IState;
import com.qyz.dp.state.state.LoginIntoSystem;
import com.qyz.dp.state.state.LoginingState;
import com.qyz.dp.state.state.UnconnectedState;

public class Context {
	
	
	public static final IState UNCONNECTED_STATE = new UnconnectedState();
	
	public static final IState CONNECTED_STATE = new ConnectedState();
	
	public static final IState LOGINING_STATE = new LoginingState();
	
	public static final IState LOGIN_INTO_SYSTEM_STATE = new LoginIntoSystem();
	
	private IState state;
	
	public Context(IState initState)
	{
//		UNCONNECTED_STATE.setContext(this);
//		CONNECTED_STATE.setContext(this);
//		LOGINING_STATE.setContext(this);
//		LOGIN_INTO_SYSTEM_STATE.setContext(this);
		initState(initState);
	}
	
	public void connect()
	{
		setState(this.state.connect(this));
	}
	
	public void beginToLogin()
	{
		setState(this.state.beginToLogin(this));
	}
	
	public void loginFailure()
	{
		setState(this.state.loginFailure(this));
	}
	
	public void loginSuccess()
	{
		setState(this.state.loginSuccess(this));
	}
	
	public void logout()
	{
		setState(this.state.logout(this));
	}
	
	public void initState(IState state)
	{
		this.setState(state);
	}
	
	public void setState(IState state)
	{
		this.state = state;
	}
	
	public IState getState()
	{
		return this.state;
	}

}
