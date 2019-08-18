package com.meuherokuapi.config;

import java.net.URISyntaxException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public class DatabaseConfig {
	
	@Bean
	public BasicDataSource basicDataSource() throws URISyntaxException {
		Dotenv dotenv;
		try {
			dotenv = Dotenv.load();
		} catch (Exception e) {
			dotenv = null;
		}
		
		String dbUrl = getEnv(dotenv, "JDBC_DATABASE_URL");
		String username = getEnv(dotenv, "JDBC_DATABASE_USERNAME");
		String password = getEnv(dotenv, "JDBC_DATABASE_PASSWORD");
		
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl(dbUrl);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		return basicDataSource;
	}

	private String getEnv(Dotenv dotenv, String name) {
		String env = null;
		if(dotenv != null) {
			env = dotenv.get(name);
		}
		if(env == null) {
			env = System.getenv(name);
		}
		return env;
	}
}
