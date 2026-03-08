package br.com.joaopedrofariaferreira.controller;
import lombok.*;

import java.net.URI;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.joaopedrofariaferreira.controller.dto.AutorDTO;
import br.com.joaopedrofariaferreira.model.Autor;
import br.com.joaopedrofariaferreira.service.AutorService;
import jakarta.persistence.Entity;

@RestController
@RequestMapping("/autores") //host:8080/autores
public class AutorController {
 //injeçao de dependências
    private final AutorService service;
    public AutorController (AutorService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> salvarAutor(@RequestBody AutorDTO autor){
        Autor autorEntidade = autor.mapearParaAutor();
        service.salvar(autorEntidade);

        URI localtion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autorEntidade.getId()).toUri();

        return ResponseEntity.created(localtion).build();
    }
}
 