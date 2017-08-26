package br.com.ximp.demo;

import br.com.ximp.demo.repository.BlogPostRepositoryEventHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@Configuration
public class DemoApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}
	@Bean
	BlogPostRepositoryEventHandler blogPostRepositoryEventHandler() {
		return new BlogPostRepositoryEventHandler();
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
