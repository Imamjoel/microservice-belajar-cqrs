package com.belajar.bankacc.cmd.api;

import org.axonframework.spring.config.AxonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@Import(AxonConfiguration.class)
public class BankAccCommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccCommandApplication.class, args);
	}

}
