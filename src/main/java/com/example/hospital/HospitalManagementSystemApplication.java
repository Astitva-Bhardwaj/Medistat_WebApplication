package com.example.hospital;

import nonapi.io.github.classgraph.json.JSONUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.w3c.dom.ls.LSOutput;


@SpringBootApplication
public class HospitalManagementSystemApplication {


	public static void main(String[] args) throws Exception {
		SpringApplication.run(HospitalManagementSystemApplication.class, args);
	}

}
