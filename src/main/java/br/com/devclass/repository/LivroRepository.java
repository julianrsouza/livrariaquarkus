package br.com.devclass.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.LockModeType;
import javax.transaction.Transactional;

import br.com.devclass.entity.Livro;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class LivroRepository implements ILivroRepository, PanacheRepositoryBase< Livro, Integer > {

	@Override
	@Transactional
	public void save( Livro livro ) {
		this.persist( livro );
	}
	
	@Override
	@Transactional
	public void remove( Integer id ) {
		this.deleteById( id );
	}

	@Override
	public List< Livro > listAll() {
		return this.findAll().list();
	}

	@Override
	public Livro findById( Integer id ) {
		return this.find( "id", id ).withLock(LockModeType.PESSIMISTIC_WRITE).firstResult();
	}

	@Override
	public List < Livro > listByEditora( String editora ) {
		return this.find( "editora", editora).list();
	}

}
