package br.com.joaopedrofariaferreira.controller.dto;

import java.util.Date;
import br.com.joaopedrofariaferreira.model.Autor;

public record AutorDTO(String nome, Date dataNascimento, String nacionalidade) {


    //Cria um autor e retorna um autor com as informaçoes que chega pelo DTO
    public Autor mapearParaAutor(){
        Autor autor = new Autor();
        autor.setNome(this.nome);
        autor.setDataNascimento(this.dataNascimento);
        autor.setNacionalidade(this.nacionalidade);
        return autor;

    }
}
