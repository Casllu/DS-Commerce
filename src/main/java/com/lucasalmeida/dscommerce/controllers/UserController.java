package com.lucasalmeida.dscommerce.controllers;

import com.lucasalmeida.dscommerce.dto.ProductDTO;
import com.lucasalmeida.dscommerce.dto.UserDTO;
import com.lucasalmeida.dscommerce.services.ProductService;
import com.lucasalmeida.dscommerce.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping(value = "/me")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
	public ResponseEntity<UserDTO> getMe() {
		return ResponseEntity.ok(service.getMe());
	}
}
