package br.com.devclass.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Autor extends PanacheEntity {
	
	private String nome;
	
	private String sobrenome;
	
	private String localNascimento;
	
	private LocalDate dataNascimento;
	
	@OneToMany(targetEntity=Livro.class,cascade = javax.persistence.CascadeType.ALL, 
	fetch = FetchType.LAZY, orphanRemoval = true)
	private Set< Livro > livros = new HashSet<>();
	
	public Autor() {
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome( String nome ) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome( String sobrenome ) {
		this.sobrenome = sobrenome;
	}

	public String getLocalNascimento() {
		return localNascimento;
	}

	public void setLocalNascimento( String localNascimento ) {
		this.localNascimento = localNascimento;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento( LocalDate dataNascimento ) {
		this.dataNascimento = dataNascimento;
	}

	public Set<Livro> getLivros() {
		return livros;
	}

	public void setLivros( Set< Livro > livros ) {
		this.livros = livros;
	}
}
