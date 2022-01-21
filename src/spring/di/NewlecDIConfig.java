package spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;

@ComponentScan("spring.di.ui")
@Configuration
public class NewlecDIConfig {
	
	@Bean
	public Exam exam() { // 함수명이라기보단 그냥 id이름이라고 생각하면 된다.
		return new NewlecExam();
	}
}
