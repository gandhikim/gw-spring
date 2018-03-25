package com.my.gw_spring.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:properties/server-config.${demonEnv:loc}${serverNo:}.properties")
public class SpringConfig {
	
	//private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(SpringConfig.class);
	
	@Autowired
	@Qualifier("config")
	private Properties config;
	
	@Value("${boss.thread.count}")
	private int bossCount;

	@Value("${worker.thread.count}")
	private int workerCount;

	@Value("${so.keepalive}")
	private boolean keepAlive;

	@Value("${so.backlog}")
	private int backlog;

	@Value("${so.linger}")
	private int linger;

	@Value("${tcp.nodelay}")
	private boolean nodelay;

	@Value("${so.rcvBuf}")
	private int rcvBuf;

	@Value("${so.sndBuf}")
	private int sndBuf;

	@Value("${front.tcp.ip}")
	private String frontServerIp;
		
	@Value("${front.tcp.port}")
	private int frontServerPort;
	
	@Value("${front.tcp.timeout}")
	private int frontServerTimeout;
	
	@Value("${back.tcp.ip}")
	private String backServerIp;
		
	@Value("${back.tcp.port}")
	private int backServerPort;
	
	@Value("${back.tcp.timeout}")
	private int backServerTimeout;

	@Value("${demonType:front}")
	private String demonType;
	
	
	public String getStrConfig(String key) {
        return config.getProperty(key);
    }
	
	public int getIntConfig(String key) {
        return Integer.valueOf(config.getProperty(key));
    }

	public int getBossCount() {
		return bossCount;
	}

	public void setBossCount(int bossCount) {
		this.bossCount = bossCount;
	}

	public int getWorkerCount() {
		return workerCount;
	}

	public void setWorkerCount(int workerCount) {
		this.workerCount = workerCount;
	}

	public boolean isKeepAlive() {
		return keepAlive;
	}

	public void setKeepAlive(boolean keepAlive) {
		this.keepAlive = keepAlive;
	}

	public int getBacklog() {
		return backlog;
	}

	public void setBacklog(int backlog) {
		this.backlog = backlog;
	}

	public int getLinger() {
		return linger;
	}

	public void setLinger(int linger) {
		this.linger = linger;
	}

	public boolean isNodelay() {
		return nodelay;
	}

	public void setNodelay(boolean nodelay) {
		this.nodelay = nodelay;
	}

	public int getRcvBuf() {
		return rcvBuf;
	}

	public void setRcvBuf(int rcvBuf) {
		this.rcvBuf = rcvBuf;
	}

	public int getSndBuf() {
		return sndBuf;
	}

	public void setSndBuf(int sndBuf) {
		this.sndBuf = sndBuf;
	}

	public String getFrontServerIp() {
		return frontServerIp;
	}

	public void setFrontServerIp(String frontServerIp) {
		this.frontServerIp = frontServerIp;
	}

	public int getFrontServerPort() {
		return frontServerPort;
	}

	public void setFrontServerPort(int frontServerPort) {
		this.frontServerPort = frontServerPort;
	}

	public int getFrontServerTimeout() {
		return frontServerTimeout;
	}

	public void setFrontServerTimeout(int frontServerTimeout) {
		this.frontServerTimeout = frontServerTimeout;
	}
	
	public String getBackServerIp() {
		return backServerIp;
	}

	public void setBackServerIp(String backServerIp) {
		this.backServerIp = backServerIp;
	}

	public int getBackServerPort() {
		return backServerPort;
	}

	public void setBackServerPort(int backServerPort) {
		this.backServerPort = backServerPort;
	}

	public int getBackServerTimeout() {
		return backServerTimeout;
	}

	public void setBackServerTimeout(int backServerTimeout) {
		this.backServerTimeout = backServerTimeout;
	}

	public String getDemonType() {
		return demonType;
	}

	public void setDemonType(String demonType) {
		this.demonType = demonType;
	}

}
