package com.my.gw_spring.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.my.gw_spring.config.SpringConfig;
import com.my.gw_spring.service.BackService;
import com.my.gw_spring.service.FrontService;


@Component("apiHandler")
public class ApiHandler {
	
	private final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger( ApiHandler.class );
	
	@Autowired
	@Qualifier("springConfig")
	private SpringConfig springConfig;
	
	@Autowired
	@Qualifier("frontServiceImpl")
	private FrontService frontService;
	
	@Autowired
	@Qualifier("backServiceImpl")
	private BackService backService;
	
	public String doProcess( String requestMsg ) throws Exception {
		
		log.info( "ApiHandler - doProcess - Start." );
		
		String responseMsg = null;
		
		if ("front".equals(springConfig.getDemonType())) {
			responseMsg = frontService.service(requestMsg);
		} else if ("back".equals(springConfig.getDemonType())) {
			responseMsg = backService.service(requestMsg);
		} else {
			// echo
			responseMsg = requestMsg;
		}
		
		return responseMsg;
		
	}

}
