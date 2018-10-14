package de.oette.lecture.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "de.oette.lecture.A01")
public class RestApiLectureApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiLectureApplication.class, args);
	}
}
