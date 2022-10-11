package br.com.devclass.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.LockModeType;
import javax.transaction.Transactional;

import br.com.devclass.entity.Autor;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class AutorRepository implements IAutorRepository, PanacheRepositoryBase< Autor, Integer > {

	@Override
	@Transactional
	public void save( Autor autor ) {
		this.persist( autor );
	}

	@Override
	@Transactional
	public void remove( Integer id ) {
		this.deleteById( id );
	}

	@Override
	public List< Autor > listAll() {
		return this.findAll().list();
	}

	@Override
	public Autor findById( Integer id ) {
		return this.find( "id" , id ).withLock(LockModeType.PESSIMISTIC_WRITE).firstResult();
	}
	
	@Override
	public List< Autor > listByNome ( String nome ) {
		return this.find( "nome", nome ).list();
	}
}
