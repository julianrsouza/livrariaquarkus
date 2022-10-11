package br.com.devclass.repository;

import java.util.List;

import br.com.devclass.entity.Livro;

public interface ILivroRepository {
	
	void save( Livro livro );
	
	void remove( Integer id );
	
	List< Livro > listAll();
	
	Livro findById( Integer id );
	
	List < Livro > listByEditora( String editora );
}
