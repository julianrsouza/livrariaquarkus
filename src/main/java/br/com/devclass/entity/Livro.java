package br.com.devclass.entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Livro extends PanacheEntity{
	
	private String titulo;
	
	private String tituloOriginal;
	
	private String editora;
	
	private Integer numeroPaginas;
	
	private Integer numeroEdicao;
	
	public Livro() {
 	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo( String titulo ) {
		this.titulo = titulo;
	}

	public String getTituloOriginal() {
		return tituloOriginal;
	}

	public void setTituloOriginal( String tituloOriginal ) {
		this.tituloOriginal = tituloOriginal;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora( String editora ) {
		this.editora = editora;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas( Integer numeroPaginas ) {
		this.numeroPaginas = numeroPaginas;
	}

	public Integer getNumeroEdicao() {
		return numeroEdicao;
	}

	public void setNumeroEdicao( Integer numeroEdicao ) {
		this.numeroEdicao = numeroEdicao;
	}
}
