package com.rab3tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@SpringBootApplication
public class SpringBootRunner extends SpringBootServletInitializer {
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRunner.class, args);
	}
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(SpringBootRunner.class);
	    }

}
*/

@SpringBootApplication
//@EnableDiscoveryClient
public class SpringBootRunner  {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRunner.class, args);
	}
	
}
