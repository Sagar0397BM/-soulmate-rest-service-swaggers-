package com.stackroute.soulMateDemo;

import com.stackroute.soulMateDemo.Domain.User;
import com.stackroute.soulMateDemo.repository.UserRepository;
import com.stackroute.soulMateDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SoulMateDemoApplication {

		@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(SoulMateDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner sendDatabase() {

		return (args) -> {
			userRepository.save(new User(103, "John", "Male", 25));
			userRepository.save(new User(104, "Pery", "Female", 30));
		};
	}

	@Component
	class ContextStartedListener implements ApplicationListener<ContextRefreshedEvent> {

		@Override
		public void onApplicationEvent(ContextRefreshedEvent event) {
			userRepository.save(new User(101, "Sagar", "Male", 25));
			userRepository.save(new User(102, "Katy Pery", "Female", 30));
		}
	}

}