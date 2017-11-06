package com.qyz.dp.state.state;

public enum StateEnum {

	UNCONNECTED(0, "UNCONNECTED" , new UnconnectedState()),
	
	CONNECTED(1, "CONNECTED", new ConnectedState()),
	
	LOGINING(2, "LOGINING", new LoginingState()),
	
	LOGIN_INTO_SYSTEM(3, "LOGIN_INTO_SYSTEM", new LoginIntoSystem());
	
	private final int key;
	
	private final String stateStr;
	
	private final IState state;
	
	StateEnum(int key, String stateStr, IState state)
	{
		this.key = key;
		
		this.stateStr = stateStr;
		
		this.state = state;
	}
	
	void printState()
	{
		System.out.println(String.format("current state: %d: %s", this.key, this.stateStr));
	}
	
	public IState getState()
	{
		return state;
	}
}
