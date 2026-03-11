package br.com.joaopedrofariaferreira.service;

import org.springframework.stereotype.Service;

import br.com.joaopedrofariaferreira.model.Autor;

@Service
public class AutorService{

    private final AutorRepository repository; //ineçao de dependencias

    public AutorService (AutorRepository repository){
        this.repository = repository;
    }

    public Autor salvar(Autor autor){
        return repository.save(autor);
    }
}