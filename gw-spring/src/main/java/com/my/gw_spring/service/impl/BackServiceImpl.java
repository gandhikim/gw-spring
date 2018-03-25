package com.my.gw_spring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.my.gw_spring.service.BackService;


@Service("backServiceImpl")
public class BackServiceImpl implements BackService {

	private final Logger log = LoggerFactory.getLogger(BackServiceImpl.class);

	public String service(String requestMsg) throws Exception {
		
		log.info( "BackServiceImpl - Service - Start." );
		
		String responseMsg = null;
		
		try {
			
			responseMsg = requestMsg;
					
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return responseMsg;
	}
	
}
