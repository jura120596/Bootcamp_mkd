package com.samsung;

import java.sql.SQLException;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MkdApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MkdApplication.class, args);
		try {
			Console.main(args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
