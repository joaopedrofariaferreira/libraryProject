package br.com.joaopedrofariaferreira.controller.dto;

import java.util.Date;
import br.com.joaopedrofariaferreira.model.Autor;

public record AutorDTO(String nome, Date dataNascimento, String nacionalidade) {


    public Autor mapearParaAutor(){
        Autor autor = new Autor();
        autor.setNome(this.nome);
        autor.setDataNascimento(this.dataNascimento);
        autor.setNacionalidade(this.nacionalidade);
        return autor;

    }
}
