/**
 * 
 */
package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naren.rest.exception.ErrorInfo;

/**
 * @author ntanwa
 *
 */
@RestController
public class HomeController {
	
	@RequestMapping(Constants.ROOT)
	public String home(){
		return "Hello this is basic auth demo access api with url /api/v1/greeting";
	}

	@RequestMapping(Constants.ACCESS_DENNIED_ENDPOINT)
	public ErrorInfo unAuthenticatedRequest(){
		return new ErrorInfo("","Access dennied. Please provide valid Credentials.");
	}

}
