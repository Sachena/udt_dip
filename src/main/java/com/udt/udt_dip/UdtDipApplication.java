package com.udt.udt_dip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class UdtDipApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdtDipApplication.class, args);
	}

}
