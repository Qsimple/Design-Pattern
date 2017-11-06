package com.qyz.dp.state.context;

import com.qyz.dp.state.state.ConnectedState;
import com.qyz.dp.state.state.IState;
import com.qyz.dp.state.state.LoginIntoSystem;
import com.qyz.dp.state.state.LoginingState;
import com.qyz.dp.state.state.StateEnum;
import com.qyz.dp.state.state.UnconnectedState;

public class Context {
	
	
	public static final IState UNCONNECTED_STATE = new UnconnectedState(StateEnum.UNCONNECTED);
	
	public static final IState CONNECTED_STATE = new ConnectedState(StateEnum.CONNECTED);
	
	public static final IState LOGINING_STATE = new LoginingState(StateEnum.LOGINING);
	
	public static final IState LOGIN_INTO_SYSTEM_STATE = new LoginIntoSystem(StateEnum.LOGIN_INTO_SYSTEM);
	
	private IState state;
	
	public Context(IState initState)
	{
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
