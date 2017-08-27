package com.util;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 应用上下文类，单例，与使用Listener加载等价
 * （如果运行在Web环境，则直接从WebApplicationContextUtils.getWebApplicationContext(event.getServletContext())）获得
 * @author zyb
 *
 */
public class SpringContextUtil
{
    private static ApplicationContext context=null;

    public static ApplicationContext getApplicationContext()
    {
        if (context == null)
        {
            context = new ClassPathXmlApplicationContext(
                new String[] {
                		//web.xml加载几个spring bean文件，这里要用到也一样要加载
                        "classpath:applicationContext.xml"
                        });
        }
        return context;
    }

    public static void setApplicationContext(ApplicationContext outcontext)
    {
        context = outcontext;
    }
}
