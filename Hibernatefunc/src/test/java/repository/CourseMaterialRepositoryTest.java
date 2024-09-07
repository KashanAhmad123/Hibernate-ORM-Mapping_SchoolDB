package repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import entity.Course;
import entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {
	
@Autowired
private CourseMaterialRepository repository;

@Test
public void saveCourseMaterial() {
	
	Course course= Course.builder()
			.title("DSA")
			.credit(4)
			.build();
	
	CourseMaterial courseMaterial= CourseMaterial.builder()
			.url("www.gfg.com")
			.course(course)
			.build();
	repository.save(courseMaterial);
	
}

@Test
public void printAllCoursesMaterial() {
	
	List<CourseMaterial> courseMaterials= repository.findAll();

	System.out.println("courseMaterial =" +courseMaterials);
}

}
