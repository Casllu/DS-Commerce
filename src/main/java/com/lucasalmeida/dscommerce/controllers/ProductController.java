package com.lucasalmeida.dscommerce.controllers;

import com.lucasalmeida.dscommerce.dto.ProductDTO;
import com.lucasalmeida.dscommerce.entities.Product;
import com.lucasalmeida.dscommerce.repositories.ProductRepository;
import com.lucasalmeida.dscommerce.services.ProductService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@GetMapping
	public ResponseEntity<Page<ProductDTO>> findAll(
			 @RequestParam(name = "name", defaultValue = "") String name, Pageable pageable) {
		return ResponseEntity.ok(service.findAll(name, pageable));
	}

	@PostMapping
	public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody ProductDTO dto) {
		return ResponseEntity.ok(service.update(id, dto));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
