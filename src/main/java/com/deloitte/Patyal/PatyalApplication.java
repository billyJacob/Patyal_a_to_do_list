
package com.deloitte.Patyal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * PatyalApplication is the name of the main class. It contains the
 * <code> public static void main()</code> method.
 * 
 * @author Billy Jacob
 * @version %I%, %G%
 * @since 1.0
 */

@SpringBootApplication
@ComponentScan("com.deloitte.Patyal")
public class PatyalApplication extends SpringBootServletInitializer {

	/**
	 * SpringBootServletInitializer is an interface to run SpringApplication from a
	 * traditional WAR deployment. It binds Servlet, Filter and
	 * ServletContextInitializer beans from the application context to the server.
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(PatyalApplication.class);
	}

	/**
	 * This is the method which is the entry point into the Patyal application if
	 * the application is deployed as a jar file
	 * 
	 * @param args the arguments that can be given as input to the main class
	 */
	public static void main(String[] args) {
		SpringApplication.run(PatyalApplication.class, args);
	}

}
