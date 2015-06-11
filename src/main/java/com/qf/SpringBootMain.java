package com.qf;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;




import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SpringBootMain {

	private static Log logger = LogFactory.getLog(SpringBootMain.class);
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringBootMain.class);  
        app.setWebEnvironment(true);  
        app.setShowBanner(false);  
        Set<Object> set = new HashSet<Object>();  
        set.add("classpath:applicationContext.xml");  
        app.setSources(set);  
        app.run(args);  
	}
	
	@Bean
	protected ServletContextListener listener() {
		return new ServletContextListener() {
			@Override
			public void contextInitialized(ServletContextEvent sce) {
				logger.info("ServletContext initialized");
			}

			@Override
			public void contextDestroyed(ServletContextEvent sce) {
				logger.info("ServletContext destroyed");
			}
		};
	}

}
