package com.userdetails;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


@EnableDiscoveryClient
@EnableZuulProxy
@EnableEurekaServer
@SpringBootApplication
public class UserDetailsApplication extends ZuulFilter{

	public static void main(String[] args) {
		SpringApplication.run(UserDetailsApplication.class, args);
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
	    HttpServletRequest request = ctx.getRequest();

	    System.out.println(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

	    return null;
	}

	@Override
	public String filterType() {
		 return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
