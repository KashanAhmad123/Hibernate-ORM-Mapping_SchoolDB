package repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import entity.Course;
import entity.Teacher;

@SpringBootTest
public class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Test
	public void saveTeacher() {
		
		Course course1= Course.builder()
				.title("hdhdh")
				.credit(4)
				.build();
		Course course2= Course.builder()
				.title("dotnet")
				.credit(9)
				.build();
		
		
		Teacher teacher= Teacher.builder()
				.firstName("Mamamj")
				.lastName("jmdjd")
				.Course(course1,course2)
				.build();
		teacherRepository.save(teacher);
		
	}

}
