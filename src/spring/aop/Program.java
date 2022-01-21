package spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.entity.Exam;
import spring.aop.entity.NewlecExam;
import spring.di.NewlecDIConfig;
import spring.di.ui.ExamConsole;

public class Program {
	public static void main(String[] args) {
		
		ApplicationContext context = 
				//new AnnotationConfigApplicationContext(NewlecDIConfig.class);
				new ClassPathXmlApplicationContext("spring/aop/setting.xml");
		
		Exam exam = (Exam)context.getBean("exam");
		System.out.printf("total is %d\n", exam.total());
		System.out.printf("total is %f\n", exam.avg());
		
		
/*
		Exam exam = new NewlecExam(1,1,1,1);
		
		
		//가짜의 exam이라서 프록시 역할을 해준다. 곁다리 업무를 수행함.
		Exam proxy = (Exam)Proxy.newProxyInstance(
						NewlecExam.class.getClassLoader(),
						new Class[] {Exam.class},
						new InvocationHandler() {

							@Override
							public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
								long start = System.currentTimeMillis();
								
								Object result = method.invoke(exam, args);
								
								long end = System.currentTimeMillis();
								String message = (end-start)+"ms 걸렸습니다.";
								System.out.println(message);

								return result;
							}
							
						});
 * 
 */
		
	}

}
