package br.com.devclass.service;

import java.util.List;

import br.com.devclass.entity.Autor;

public interface IAutorService {
	
	void save( Autor autor );
	
	void remove( Integer id );

	List< Autor > listAll();
	
	Autor findById( Integer id );
	
	List< Autor > listByNome( String nome );
	
}
