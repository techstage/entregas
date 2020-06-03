package io.techstage.entregas.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.techstage.entregas.model.Entrega;
import io.techstage.entregas.repository.Entregas;

@CrossOrigin
@RestController	
@RequestMapping("/entregas")
public class EntregasResource {
  
	@Autowired
	private Entregas entregas;
	
	@CrossOrigin
	@PostMapping
	public Entrega adicionar(@Valid @RequestBody Entrega entrega) {
		return entregas.save(entrega);
	}
	
	@CrossOrigin
	@GetMapping
	public List<Entrega> listar() {
		return entregas.findAll();
	}
  
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Entrega> buscar(@PathVariable Long id) {
    Entrega entrega = entregas.findById(id).get();
    
		if (entrega == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(entrega);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<Entrega> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Entrega entrega) {
				Entrega existente = entregas.findById(id).get();
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(entrega, existente, "id");
		
		existente = entregas.save(existente);
		
		return ResponseEntity.ok(existente);
	}

	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		Entrega entrega = entregas.findById(id).get();
		
		if (entrega == null) {
			return ResponseEntity.notFound().build();
		}
		
		entregas.delete(entrega);
		
		return ResponseEntity.noContent().build();
	}
}