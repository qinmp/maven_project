package com.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**加载spring上下文
 * @author zyb
 * since 2011-4-11
 */
@WebListener
public class SpringContextLoader extends ContextLoaderListener{

	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		SpringContextUtil.setApplicationContext(WebApplicationContextUtils.getWebApplicationContext(event.getServletContext()));
	}
	
}
