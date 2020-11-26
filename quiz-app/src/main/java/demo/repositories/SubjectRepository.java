package demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import demo.domain.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long>{
	List<Subject> findSubjectsByNameContaining(String name);
}
