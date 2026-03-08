package br.com.joaopedrofariaferreira.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "autor", schema = "public")
@Data
public class Autor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "dataNascimento", length = 100, nullable = false)
    private Date dataNascimento;

    @Column(name = "nacionalidade", length = 100, nullable = false)
    private String nacionalidade;

    public void setDataNascimento(Date dataNascimento2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDataNascimento'");
    }

    //@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = fetch)
    //private List<Livros> livros;
}
