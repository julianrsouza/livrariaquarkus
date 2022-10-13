package br.com.devclass.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import br.com.devclass.entity.Livro;
import br.com.devclass.service.ILivroService;

@Path( "/api/livro" )
public class LivroController {
	
	@Inject
	ILivroService livroService;
	
	@POST
	@APIResponses( {
		@APIResponse(
			responseCode = "200",
			description = "Criado com sucesso"
		),
		@APIResponse(
			responseCode = "400",
			description = "Requisição inválida"
		)
		} 
	)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create( Livro livro ) {
		this.livroService.save( livro );
		return Response.ok( ).build();
	}
	
	@PATCH
	@APIResponses( {
		@APIResponse(
			responseCode = "200",
			description = "Editado com sucesso"
		),
		@APIResponse(
			responseCode = "404",
			description = "Não encontrado o elemento para edição"
		)
		}
	)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update( Livro livro ) {
		this.livroService.save( livro );
		return Response.ok().build();
	}
	
	@DELETE
	@APIResponses( {
		@APIResponse(
			responseCode = "200",
			description = "Sucesso"
		),
		@APIResponse(
			responseCode = "404",
			description = "Não encontrado"
		)
		}
	)
	@Path( "/{id}" )
	public Response remove( @PathParam( value = "id" )  Integer id ) {
		this.livroService.remove( id );
		return Response.ok().build();
	}
	
	@GET
	@APIResponses( {
		@APIResponse(
			responseCode = "200",
			description = "Busca efetuada com sucesso"
		),
		@APIResponse(
			responseCode = "404",
			description = "Livro não encontrado"
		)
		}
	)
	@Path( "/{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response findById( @PathParam( value = "id" ) Integer id ) {
		this.livroService.findById( id );
		return Response.ok().build();
	}
	
	@GET
	@APIResponses( 
		@APIResponse(
			responseCode = "200",
			description = "Busca efetuada com sucesso"
		)
	)
	@Produces( MediaType.APPLICATION_JSON )
	public Response listAll() {
		this.livroService.listAll();
		return Response.ok().build();
	}
	
	@GET
	@APIResponses( {
		@APIResponse(
			responseCode = "200",
			description = "Busca efetuada com sucesso"
		),
		@APIResponse(
			responseCode = "404",
			description = "Livro não encontrado"
		)
		}
	)
	@Path( "/{editora}" )
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response listByEditora( @PathParam( value = "editora" ) String editora ) {
		this.livroService.listByEditora( editora );
		return Response.ok().build();
	}
}
