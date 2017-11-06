package com.qyz.dp.config;

import static com.qyz.dp.state.events.RegEventEnum.BEGIN_TO_LOGIN;
import static com.qyz.dp.state.events.RegEventEnum.CONNECT;
import static com.qyz.dp.state.events.RegEventEnum.LOGIN_FAILURE;
import static com.qyz.dp.state.events.RegEventEnum.LOGIN_SUCCESS;
import static com.qyz.dp.state.events.RegEventEnum.LOGOUT;
import static com.qyz.dp.state.state.RegStatusEnum.CONNECTED;
import static com.qyz.dp.state.state.RegStatusEnum.LOGINING;
import static com.qyz.dp.state.state.RegStatusEnum.LOGIN_INTO_SYSTEM;
import static com.qyz.dp.state.state.RegStatusEnum.UNCONNECTED;

import java.util.EnumSet;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import com.qyz.dp.state.events.RegEventEnum;
import com.qyz.dp.state.state.RegStatusEnum;

@Configuration
@EnableStateMachine // 开始状态机配置
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<RegStatusEnum, RegEventEnum>{

	/**
	 * 配置状态机状态
	 */
	@Override
	public void configure(StateMachineStateConfigurer<RegStatusEnum, RegEventEnum> states) throws Exception {
//		super.configure(states);
		states.withStates()
		// 初始化状态机状态
		.initial(RegStatusEnum.UNCONNECTED)
		// 指定状态机的所有状态
		.states(EnumSet.allOf(RegStatusEnum.class));
	}

	/**
	 * 配置状态机状态转换
	 */
	@Override
	public void configure(StateMachineTransitionConfigurer<RegStatusEnum, RegEventEnum> transitions) throws Exception {
//		super.configure(transitions);
		
		// 1. connect UNCONNECTED -> CONNECTED
		transitions.withExternal()
			.source(UNCONNECTED)
			.target(CONNECTED)
			.event(CONNECT)
		// 2. beginToLogin CONNECTED -> LOGINING
		.and().withExternal()
			.source(CONNECTED)
			.target(LOGINING)
			.event(BEGIN_TO_LOGIN)
		// 3. login failure LOGINING -> UNCONNECTED
		.and().withExternal()
			.source(LOGINING)
			.target(UNCONNECTED)
			.event(LOGIN_FAILURE)
		// 4. login success LOGINING -> LOGIN_INTO_SYSTEM
		.and().withExternal()
			.source(LOGINING)
			.target(LOGIN_INTO_SYSTEM)
			.event(LOGIN_SUCCESS)
		// 5. logout LOGIN_INTO_SYSTEM -> UNCONNECTED
		.and().withExternal()
			.source(LOGIN_INTO_SYSTEM)
			.target(UNCONNECTED)
			.event(LOGOUT);
	}

	@Override
	public void configure(StateMachineConfigurationConfigurer<RegStatusEnum, RegEventEnum> config) throws Exception {
		
//		config.withConfiguration().listener(new StateMachineEventConfig());
		
	}
	

	
	
	
}
