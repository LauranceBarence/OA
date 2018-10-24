<<<<<<< HEAD
package com.bwf.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bwf.entity.Operate;
import com.bwf.entity.User;

public class OperateInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		

		System.out.println( request.getRequestURI() );
		
		boolean sessionContainsUri = false;
		User user = (User) request.getSession().getAttribute("currentUser"); 
		List<Operate> os = user.getOperates();
		
		//System.out.println(user.getOperates());
		for( Operate o : user.getOperates() ) {
			if (o.getOperateAction()!=null&&request.getRequestURI().contains( o.getOperateAction() ) ) {
				sessionContainsUri = true;
			}
		}
		
		if ( sessionContainsUri ) {
			return true;
		} else {
			response.sendRedirect( request.getContextPath() + "/error/error");
			return false;
		}
	}
}
=======
package com.bwf.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bwf.entity.Operate;
import com.bwf.entity.User;

public class OperateInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		

		
		boolean sessionContainsUri = false;
		User user = (User) request.getSession().getAttribute("currentUser"); 
		
		//System.out.println(user.getOperates());
		for( Operate o : user.getOperates() ) {
			if (o.getOperateAction()!=null&&request.getRequestURI().contains( o.getOperateAction() ) ) {
				sessionContainsUri = true;
			}
		}
		
		if ( sessionContainsUri ) {
			return true;
		} else {
			response.sendRedirect( request.getContextPath() + "/error/error");
			return false;
		}
		
		//return true;
	}
}
>>>>>>> bqr
