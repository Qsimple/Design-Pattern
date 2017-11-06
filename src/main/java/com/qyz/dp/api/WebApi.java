package com.qyz.dp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qyz.dp.state.events.RegEventEnum;
import com.qyz.dp.state.state.RegStatusEnum;

@RestController
public class WebApi {

	@Autowired
	private StateMachine<RegStatusEnum, RegEventEnum> stateMachine;
	
	@GetMapping(value = "/testStateMachine")
	public void testStateMachine()
	{
		stateMachine.start();
//		stateMachine.sendEvent(RegEventEnum.CONNECT);
//		stateMachine.sendEvent(RegEventEnum.BEGIN_TO_LOGIN);
//		stateMachine.sendEvent(RegEventEnum.LOGIN_FAILURE);
		stateMachine.sendEvent(RegEventEnum.LOGOUT);
	}
}
