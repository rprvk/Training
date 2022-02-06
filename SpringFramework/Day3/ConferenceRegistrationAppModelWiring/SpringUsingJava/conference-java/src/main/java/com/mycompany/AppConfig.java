package com.mycompany;

import java.util.Calendar;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.mycompany.repository.HibernateSpeakerRepositoryImpl;
import com.mycompany.repository.SpeakerRepository;
import com.mycompany.service.SpeakerService;
import com.mycompany.service.SpeakerServiceImpl;
import com.mycompany.util.CalendarFactory;

@Configuration
@ComponentScan({ "com.mycompany" })
public class AppConfig {

	@Bean(name = "cal")
	public CalendarFactory calFactory() {

		CalendarFactory factory = new CalendarFactory();
		factory.addDays(2);
		return factory;
	}

	@Bean
	public Calendar cal() throws Exception { //this is the actual instance of caLender 
		return calFactory().getObject();
	}

//	@Bean(name = "speakerService")
//	@Scope(value = BeanDefinition.SCOPE_SINGLETON)
////	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
//	public SpeakerService getSpeakerService() {
//
////		SpeakerServiceImpl service = new SpeakerServiceImpl();
////		service.setRepository(getSpeakerRepository());
//
////		SpeakerServiceImpl service = new SpeakerServiceImpl(getSpeakerRepository());
//
//		SpeakerServiceImpl service = new SpeakerServiceImpl();
//		return service;
//	}

//	@Bean(name = "speakerRepository")
//	public SpeakerRepository getSpeakerRepository() {
//
//		return new HibernateSpeakerRepositoryImpl();
//	}

}
