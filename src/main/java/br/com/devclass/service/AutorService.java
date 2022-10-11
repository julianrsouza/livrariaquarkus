package br.com.devclass.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.devclass.entity.Autor;
import br.com.devclass.repository.IAutorRepository;

@ApplicationScoped
public class AutorService implements IAutorService{

	@Inject
	IAutorRepository autorRepository;
	
	@Override
	public void save( Autor autor ) {
		if ( autor.id != null ) {
			this.update( autor );
		} else {
			this.create( autor );
		}
	}

	@Override
	public void remove( Integer id ) {
		this.autorRepository.remove( id );
	}

	@Override
	public List< Autor > listAll() {
		return this.autorRepository.listAll();
	}

	@Override
	public Autor findById( Integer id ) {
		return this.autorRepository.findById( id );
	}
	
	@Override
	public List< Autor > listByNome( String nome ) {
		return this.autorRepository.listByNome( nome );
	}
	
	private void create( Autor autor ) {
		this.autorRepository.save( autor );
	}
	
	private void update( Autor autor ) {
		Optional< Autor > autorBuscado = Optional.ofNullable(this.autorRepository.findById( autor.id.intValue() ));
		if ( autorBuscado.isEmpty() ) {
			return;
		}
		Autor autorEditado = autorBuscado.get();
		autorEditado = autor;
		this.autorRepository.save( autorEditado );
	}
	
}
