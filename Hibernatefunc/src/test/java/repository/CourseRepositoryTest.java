package repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import entity.Course;
import entity.Student;
import entity.Teacher;

@SpringBootTest
public class CourseRepositoryTest {
	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void printCourses() {
		List<Course> courses= courseRepository.findAll();
		
		System.out.println("Courses=" +courses);
	}
	
	@Test
	public void saveCoursesByTeacher () {
		
		Teacher teacher = Teacher.builder()
				.firstName("Neha")
				.lastName("Sharma")
				.build();
		
		Course course = Course.builder()
				.title("SAP")
				.credit(9)
				.build();
				
		courseRepository.save(course);
	}
	
	@Test //<---- Pagination is used to get record or page records, while sorting is used to in which sorted form to want to fetch data
	public void findAllPagination() {
		PageRequest firstPagewiththreerecord= 
		PageRequest.of(0, 3);
		
		PageRequest secondPagewithtwoRecord=PageRequest.of(1, 2);
		List<Course> course = courseRepository.findAll(firstPagewiththreerecord).getContent();
		 long totalElement= courseRepository.findAll(firstPagewiththreerecord).getTotalPages();
		 
		 System.out.println("Course List=" +course);
		 System.out.println("TotalPage ="+totalElement);
		 
	}

	public void saveCourseWithStudentsandTeacher() {
		
		Teacher teacher = Teacher.builder()
				.firstName("Salini")
				.lastName("Dubey")
				.build();
		Student student= Student.builder()
				.fisrstName("Pankage")
				.lastName("Sinha")
				.emailId("ss.jj@gmail.com")
				.build();
		Course course= Course.builder()
				.title("GEN_AI")
				.credit(8)
				.build();
		
		course.addStudent(student);
		
		courseRepository.save(course);
		
		
	}

}
