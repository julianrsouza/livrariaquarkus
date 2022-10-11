package br.com.devclass.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.devclass.entity.Livro;
import br.com.devclass.repository.ILivroRepository;

@ApplicationScoped
public class LivroService implements ILivroService {

	@Inject
	ILivroRepository livroRepository;
	
	@Override
	public void save( Livro livro ) {
		if ( livro.id != null ) {
			this.update( livro );
		} else {
			this.create( livro );
		}
	}

	@Override
	public void remove( Integer id ) {
		this.livroRepository.remove( id );
	}

	@Override
	public List< Livro > listAll() {
		return this.livroRepository.listAll();
	}

	@Override
	public Livro findById( Integer id ) {
		return this.livroRepository.findById( id );
	}
	
	@Override
	public List< Livro > listByEditora( String editora ) {
		return this.livroRepository.listByEditora( editora );
	}
	
	private void create( Livro livro ) {
		this.livroRepository.save( livro );
	}
	
	private void update( Livro livro ) {
		Optional< Livro > livroBuscado = Optional.ofNullable(this.livroRepository.findById( livro.id.intValue() ));
		if ( livroBuscado.isEmpty() ) {
			return;
		}
		Livro livroEditado = livroBuscado.get();
		livroEditado = livro;
		this.livroRepository.save( livroEditado );
	}
}
