package br.com.joaopedrofariaferreira.service;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joaopedrofariaferreira.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

}
