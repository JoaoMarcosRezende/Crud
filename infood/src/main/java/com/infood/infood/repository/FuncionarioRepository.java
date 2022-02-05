package com.infood.infood.repository;

import org.springframework.data.repository.CrudRepository;

import com.infood.infood.models.Funcionarios;

public interface FuncionarioRepository extends CrudRepository<Funcionarios, String>{
		Funcionarios findByCodigo(long codigo);
}

