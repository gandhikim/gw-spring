package com.my.gw_spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.my.gw_spring.netty.NettyClient;
import com.my.gw_spring.service.FrontService;
import com.my.gw_spring.config.SpringConfig;
import com.my.gw_spring.mapper.FrontMapper;


@Service("frontServiceImpl")
public class FrontServiceImpl implements FrontService {

	private final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(FrontServiceImpl.class);
	
	@Autowired
	private FrontMapper frontMapper;
	
	@Autowired
	@Qualifier("springConfig")
	private SpringConfig springConfig;
	
	NettyClient client = new NettyClient();
	
	public String service(String requestMsg) throws Exception {
		
		log.info( "FrontServiceImpl - Service - Start." );
		
		String responseMsg = null;
		
		try {
			
			responseMsg = client.send(	springConfig.getBackServerIp(), 
										springConfig.getBackServerPort(), 
										requestMsg, 
										springConfig.getBackServerTimeout());
			
			if("testMsg[6".equals(requestMsg))
				log.info("frontMapper.selectDBConnectTest[" + frontMapper.selectDBConnectTest());
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return responseMsg;
	}

	
}
