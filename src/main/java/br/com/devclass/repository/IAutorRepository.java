package br.com.devclass.repository;

import java.util.List;

import br.com.devclass.entity.Autor;

public interface IAutorRepository {
	
	void save( Autor autor );
	
	void remove( Integer id );

	List< Autor > listAll();
	
	Autor findById( Integer id );
	
	List< Autor > listByNome( String nome );
	
}
