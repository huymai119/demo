
package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Subject;
import demo.exception.SubjectNotFoundException;
import demo.service.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
	@Autowired 
	// con kieesn to
	private SubjectService subjectService;

	@GetMapping("/{id}/get")
	public Subject get(@PathVariable Long id) {
		Subject subject = subjectService.findById(id).orElseThrow(() -> new SubjectNotFoundException());
		return subject;
	}

	@GetMapping()
	public List<Subject> getAll() {
		return (List<Subject>) subjectService.findAll();
	}

	@GetMapping("/find/{name}")
	public List<Subject> findByName(@PathVariable String name) {
		return subjectService.findSubjectsByNameContaining(name);
	}

	@PostMapping("")
	public Subject insert(@RequestBody Subject subject) {
		return subjectService.save(subject);
	}

	@PutMapping("/{id}/update")
	public Subject update(@PathVariable Long id, @RequestBody Subject subject) {
		return subjectService.findById(id).map(sub -> {
			sub.setName(subject.getName());
			sub.setLogo(subject.getLogo());

			return subjectService.save(sub);
		}).get();
	}
	
	@DeleteMapping(path = "/{id}/delete")
	public ResponseEntity<Void> deleteSubject(@PathVariable("id") Long id){
		subjectService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
