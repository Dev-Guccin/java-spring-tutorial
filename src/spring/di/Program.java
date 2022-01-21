package spring.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
		
		/* 스프링에게 지시하는 방법으로 코드 변
		Exam exam = new NewlecExam();
		// 부품 조립을 하듯이 DI를 꽂아 넣을 수 있다.
		ExamConsole console = new InlineExamConsole(); // DI
		console.setExam(exam);
		*/
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(NewlecDIConfig.class);
				//new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
		//Exam exam = context.getBean(Exam.class);
		//System.out.println(exam.toString());
		
		// 부품을 생성하고 끼워주는걸 spring이 하는것이다.
		ExamConsole console = (ExamConsole) context.getBean("console");
		//ExamConsole console = context.getBean(ExamConsole.class); // 인터페이스 형식으로 바로 불러옴. 형변환 필요없
		console.print();
		
		
		//List<Exam> exams =(List<Exam>)context.getBean("exams");
		//exams.add(new NewlecExam(1,1,1,1)); 이제 없어도 된다.
		
//		for(Exam e: exams)
//			System.out.println(e);
	}

}
