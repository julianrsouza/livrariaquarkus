package br.com.devclass.service;

import java.util.List;

import br.com.devclass.entity.Livro;

public interface ILivroService {

	void save( Livro livro );
	
	void remove( Integer id );
	
	List< Livro > listAll();
	
	Livro findById( Integer id );
	
	List< Livro > listByEditora( String editora );

}
