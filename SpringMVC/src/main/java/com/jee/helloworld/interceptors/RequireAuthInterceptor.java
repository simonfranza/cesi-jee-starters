package com.jee.helloworld.interceptors;

import com.jee.helloworld.controller.UserController;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequireAuthInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle (
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler
	) throws Exception {
		// set few parameters to handle ajax request from different host
		Object authToken = request.getSession().getAttribute("authToken");
		if (authToken == null || !UserController.isTokenValid(authToken.toString())) {
			response.sendRedirect(String.format("%s/user/login", request.getContextPath()));
		}
		return super.preHandle(request, response, handler);
	}
}
