package com.qyz.dp.state.state;

import com.qyz.dp.state.context.Context;

public enum StateEnum implements IState{

	
	UNCONNECTED(0, "UNCONNECTED"){
		@Override
		public IState connect(Context context) {
			IState nextState = StateEnum.CONNECTED;
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
	},
	
	CONNECTED(1, "CONNECTED"){

		@Override
		public IState connect(Context context) {
			IState nextState = StateEnum.CONNECTED;
			System.out.println(String.format("已经连接了，Switch state from %s to %s", context.getState(), nextState));
			return nextState;
		}

		@Override
		public IState beginToLogin(Context context) {
			IState nextState = StateEnum.LOGINING;
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
	},
	
	LOGINING(2, "LOGINING"){
		@Override
		public IState connect(Context context) {
			throw new RuntimeException("处在登录中");
		}
		@Override
		public IState beginToLogin(Context context) {
			IState nextState = StateEnum.LOGINING;
			System.out.println(String.format("已经连接并且正在登录，Switch state from %s to %s", context.getState(), nextState));
			return nextState;
		}

		@Override
		public IState loginFailure(Context context) {
			IState nextState = StateEnum.UNCONNECTED;
			System.out.println(String.format("Switch state from %s to %s", context.getState(), nextState));
			return nextState;
		}

		@Override
		public IState loginSuccess(Context context) {
			IState nextState = StateEnum.LOGIN_INTO_SYSTEM;
			System.out.println(String.format("Switch state from %s to %s", context.getState(), nextState));
			return nextState;
		}

		@Override
		public IState logout(Context context) {
			throw new RuntimeException("处在登录中");
		}
	},
	
	LOGIN_INTO_SYSTEM(3, "LOGIN_INTO_SYSTEM"){
		@Override
		public IState connect(Context context) {
			throw new RuntimeException("已经登录进系统");
		}
		@Override
		public IState beginToLogin(Context context) {
			throw new RuntimeException("已经登录进系统");
		}

		@Override
		public IState loginFailure(Context context) {
			throw new RuntimeException("已经登录进系统");
		}

		@Override
		public IState loginSuccess(Context context) {
			IState nextState = StateEnum.LOGIN_INTO_SYSTEM;
			System.out.println(String.format("已经登录进系统了，Switch state from %s to %s", context.getState(), nextState));
			return nextState;
		}
		@Override
		public IState logout(Context context) {
			IState nextState = StateEnum.UNCONNECTED;
			System.out.println(String.format("Switch state from %s to %s", context.getState(), nextState));
			return nextState;
		}
	};
	
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
	
	@Override
	public String toString()
	{
		return this.stateStr;
	}

}
