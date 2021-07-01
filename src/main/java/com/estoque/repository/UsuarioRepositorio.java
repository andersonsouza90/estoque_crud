package com.estoque.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estoque.model.Usuario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long>{

}
