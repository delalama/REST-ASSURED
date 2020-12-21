package com.javainuse;

import com.javainuse.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SpringBootHelloWorldApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext appContext;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
		Employee employee = new Employee();
		employee.setName("joxxe");
		employee.setEmpId("3");
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(appContext.getDisplayName());
		System.out.println(appContext.getApplicationName());
		System.out.println(appContext.getId());
		System.out.println(appContext.getParent());
		System.out.println(appContext.getStartupDate());

	}
}