package demo.service;

import java.util.List;
import java.util.Optional;

import demo.domain.Subject;

public interface SubjectService {

	void deleteAll();

	void deleteAll(Iterable<? extends Subject> entities);

	void delete(Subject entity);

	void deleteById(Long id);

	long count();

	Iterable<Subject> findAllById(Iterable<Long> ids);

	Iterable<Subject> findAll();

	boolean existsById(Long id);

	Optional<Subject> findById(Long id);

	Iterable<Subject> saveAll(Iterable<Subject> entities);

	Subject save(Subject entity);

	List<Subject> findSubjectsByNameContaining(String name);

}
