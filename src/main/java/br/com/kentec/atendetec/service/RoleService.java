package br.com.kentec.atendetec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.atendetec.domain.Role;
import br.com.kentec.atendetec.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository rr;
	
	public Iterable<Role> listarRole(){
		return rr.findAll();
	}
}
