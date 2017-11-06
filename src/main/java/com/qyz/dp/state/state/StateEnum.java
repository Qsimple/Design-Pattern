package com.qyz.dp.state.state;

public enum StateEnum {

	
	UNCONNECTED(0, "UNCONNECTED"),
	
	CONNECTED(1, "CONNECTED"),
	
	LOGINING(2, "LOGINING"),
	
	LOGIN_INTO_SYSTEM(3, "LOGIN_INTO_SYSTEM");
	
	private int key;
	
	private String stateStr;
	
	StateEnum(int key, String stateStr)
	{
		this.key = key;
		
		this.stateStr = stateStr;
	}
	
	void printState()
	{
		System.out.println(String.format("current state: %d: %s", this.key, this.stateStr));
	}
}
