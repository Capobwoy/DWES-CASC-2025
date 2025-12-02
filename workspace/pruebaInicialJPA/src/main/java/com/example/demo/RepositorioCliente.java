package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RepositorioCliente extends CrudRepository<Cliente, Long>{
	List<Cliente> findByLastApellido(String apellido);
	
	Cliente findById(long id);
}
