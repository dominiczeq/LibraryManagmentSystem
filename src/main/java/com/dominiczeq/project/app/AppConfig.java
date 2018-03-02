package com.dominiczeq.project.app;

import java.util.Locale;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.dominiczeq.project.converter.AuthorConverter;
import com.dominiczeq.project.converter.BookConverter;
import com.dominiczeq.project.converter.GenreConverter;
import com.dominiczeq.project.converter.PublisherConverter;
import com.dominiczeq.project.converter.UserConverter;

@Configuration
@ComponentScan(basePackages = { "com.dominiczeq" })

@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.dominiczeq.project.repository" })
public class AppConfig extends WebMvcConfigurerAdapter {

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
		emfb.setPersistenceUnitName("sql11224141");
		return emfb;
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		registry.addResourceHandler("resources/**").addResourceLocations("/WEB-INF/resources/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager tm = new JpaTransactionManager(emf);
		return tm;
	}

	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(authorConverter());
		registry.addConverter(publisherConverter());
		registry.addConverter(genreConverter());
		registry.addConverter(bookConverter());
		registry.addConverter(userConverter());
	}

	@Bean
	public PublisherConverter publisherConverter() {
		return new PublisherConverter();
	}

	@Bean
	public AuthorConverter authorConverter() {
		return new AuthorConverter();
	}
	
	@Bean
	public GenreConverter genreConverter() {
		return new GenreConverter();
	}
	
	@Bean BookConverter bookConverter() {
		return new BookConverter();
	}
	
	@Bean UserConverter userConverter() {
		return new UserConverter();
	}

	@Bean(name = "localeResolver")
	public LocaleContextResolver getLocaleContextResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("pl", "PL"));
		return localeResolver;
	}
}
