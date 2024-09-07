package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

	
}
