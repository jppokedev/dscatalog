package com.bitworld.dscatalog.controller;

import com.bitworld.dscatalog.dto.EmailDTO;
import com.bitworld.dscatalog.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

	@Autowired
	private AuthService service;

	@PostMapping(value = "/recover-token")
	public ResponseEntity<Void> createRecoverToken(@Valid @RequestBody EmailDTO body) {
		service.createRecoverToken(body);
		return ResponseEntity.noContent().build();
	}
}