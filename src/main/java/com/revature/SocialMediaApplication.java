package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@PropertySource("test.properties")
//@EnableScheduling
public class SocialMediaApplication {

//	@Autowired
//	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaApplication.class, args);
	}

//	@Scheduled(fixedDelay = 3000L)
//	public void foo(){
//		System.out.println(jdbcTemplate.queryForObject("select 1", String.class));
//	}

}
