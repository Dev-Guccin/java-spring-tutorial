package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component("console")
public class InlineExamConsole implements ExamConsole {

	@Autowired
	//@Qualifier("exam2")
	private Exam exam;
	
	public InlineExamConsole() {
		// TODO Auto-generated constructor stub
		System.out.println("constructor");
	}
	
	public InlineExamConsole(Exam exam) {
		this.exam = exam;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.printf("total is %d, avg is %f\n",exam.total(), exam.avg() );
	}
	
	@Override 
	public void setExam(Exam exam) {
		// TODO Auto-generated method stub
		System.out.println("setter DI");
		this.exam = exam;
	}

}
