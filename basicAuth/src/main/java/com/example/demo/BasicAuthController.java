/**
 * 
 */
package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ntanwa
 *
 */
@RestController
@RequestMapping(Constants.BASIC_AUTH_ENDPOINT)
public class BasicAuthController {

	@RequestMapping(Constants.GREETING_ENDPOINT)
	public String home(HttpServletRequest request){
		return "Hello, "+request.getAttribute(Constants.USER_NAME);
	}
}
