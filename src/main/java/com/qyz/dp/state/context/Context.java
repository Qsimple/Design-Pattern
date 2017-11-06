package com.qyz.dp.state.context;

import com.qyz.dp.state.state.IState;

public class Context {
	
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
