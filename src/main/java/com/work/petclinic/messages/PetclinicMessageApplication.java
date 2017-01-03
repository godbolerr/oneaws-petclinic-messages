package com.work.petclinic.messages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.actuate.system.EmbeddedServerPortFileWriter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan
@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@EnableJpaRepositories("com.work.petclinic.messages.repository")
public class PetclinicMessageApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication springApplication = new SpringApplication(PetclinicMessageApplication.class);
		springApplication.addListeners(new ApplicationPidFileWriter(), new EmbeddedServerPortFileWriter());
		springApplication.run(args);
	}
}
