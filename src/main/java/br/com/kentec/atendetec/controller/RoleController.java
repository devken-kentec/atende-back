package br.com.kentec.atendetec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.atendetec.domain.Role;
import br.com.kentec.atendetec.service.RoleService;

@RestController
@RequestMapping("/atendeTec/api/role")
public class RoleController {
	
	@Autowired
	private RoleService rs;
	
	@GetMapping()
	public ResponseEntity<Iterable<Role>> listarRole(){
		return ResponseEntity.ok(rs.listarRole());
	}

}
