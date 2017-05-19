package com.muke.employee.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TimerInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
	ActionContext actioncontext = ActionContext.getContext();
	Map<String, Object> session = actioncontext.getSession();
	if(session.get("existEmployee") != null ){
		String result = arg0.invoke();
		return result;
	}else{
		
	return "login";
	   }
	}

}
