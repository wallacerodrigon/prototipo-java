/**
 * 
 */
package br.jus.trf1.api.rest.comum;

import java.io.Serializable;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.jus.trf1.api.EntidadeBasica;
import br.jus.trf1.api.excecoes.WebServiceException;

/**
 * @author wallace
 *
 */
public interface ContratoPadraoRest<T extends EntidadeBasica<?>> extends Serializable {

	 @GET
	 @Path("/ping")
	 Response novo() throws WebServiceException;
	
	 @POST
	 Response incluir(T objeto) throws WebServiceException;
	 
	 @PUT
	 Response alterar(T objeto) throws WebServiceException;
	 
	 @DELETE
	 @Path("/{idChaveObjeto}")
	 Response excluir(@PathParam("idChaveObjeto") Integer idChaveObjeto) throws WebServiceException;
	 
	 @GET
	 @Path("/{idProcura}")
	 Response procurar(@PathParam("idProcura") Integer idProcura) throws WebServiceException;
	 
	 @GET
	 Response listar() throws WebServiceException;
	 
}
