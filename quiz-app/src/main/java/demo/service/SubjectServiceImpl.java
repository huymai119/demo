package demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.domain.Subject;
import demo.repositories.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService{
	@Autowired
	private SubjectRepository subjectRepository;
	

	@Override
	public Subject save(Subject entity) {
		return subjectRepository.save(entity);
	}

	@Override
	public Iterable<Subject> saveAll(Iterable<Subject> entities) {
		return subjectRepository.saveAll(entities);
	}

	@Override
	public Optional<Subject> findById(Long id) {
		return subjectRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return subjectRepository.existsById(id);
	}

	@Override
	public Iterable<Subject> findAll() {
		return subjectRepository.findAll();
	}

	@Override
	public Iterable<Subject> findAllById(Iterable<Long> ids) {
		return subjectRepository.findAllById(ids);
	}

	@Override
	public List<Subject> findSubjectsByNameContaining(String name) {
		return subjectRepository.findSubjectsByNameContaining(name);
	}

	@Override
	public long count() {
		return subjectRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		subjectRepository.deleteById(id);
	}

	@Override
	public void delete(Subject entity) {
		subjectRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Subject> entities) {
		subjectRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		subjectRepository.deleteAll();
	}
}
