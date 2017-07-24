/**
 * 
 */
package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ntanwa
 *
 */
@Component
public class RequestInterceptor implements HandlerInterceptor {
	
	@Autowired
	private BaseEncoderDecoder encoderDecoder;

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestInterceptor.class);
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
        String credentials = request.getHeader(Constants.AUTHORIZATION);
        if(credentials == null){
        	response.sendRedirect(Constants.ACCESS_DENNIED_ENDPOINT);
			return false;
        }
        credentials = encoderDecoder.decode(credentials.replace(Constants.BASIC_,""));
        request.setAttribute(Constants.USER_NAME, credentials.split(":")[0]);
		LOGGER.info("RequestInterceptor preHandle()");
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		LOGGER.info("RequestInterceptor postHandle( ) ");
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		LOGGER.info("RequestInterceptor After Completion....");
	}

}
