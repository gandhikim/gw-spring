package com.my.gw_spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:appContext/applicationContext.xml");
		ctx.registerShutdownHook();
		ctx.close();
    }
}
