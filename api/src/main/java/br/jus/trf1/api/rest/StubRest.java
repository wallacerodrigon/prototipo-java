/**
 * 
 */
package br.jus.trf1.api.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.jus.trf1.api.EntidadeBasica;
import br.jus.trf1.api.excecoes.WebServiceException;
import br.jus.trf1.api.negocio.servicos.comum.CrudPadraoServico;
import br.jus.trf1.api.rest.comum.RequisicaoRestPadrao;
import br.jus.trf1.api.rest.interceptors.RequisicaoInterceptor;

/**
 * @author wallace
 *
 */
@Named
@RequestScoped

@Path("/stub")
@Produces(value={MediaType.APPLICATION_JSON})
@Consumes(value={MediaType.APPLICATION_JSON})
@Interceptors({RequisicaoInterceptor.class})

@SuppressWarnings("serial")
public class StubRest extends RequisicaoRestPadrao {


	@GET
	@Path("/ping")
	public Response testePing(){
		return Response.ok("Ping").build();
	}

	/* (non-Javadoc)
	 * @see br.jus.trf1.api.rest.comum.ContratoPadraoRest#incluir(br.jus.trf1.api.EntidadeBasica)
	 */
	@Override
	public Response incluir(EntidadeBasica objeto) throws WebServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see br.jus.trf1.api.rest.comum.ContratoPadraoRest#alterar(br.jus.trf1.api.EntidadeBasica)
	 */
	@Override
	public Response alterar(EntidadeBasica objeto) throws WebServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see br.jus.trf1.api.rest.comum.ContratoPadraoRest#excluir(java.lang.Integer)
	 */
	@Override
	public Response excluir(Integer idChaveObjeto) throws WebServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see br.jus.trf1.api.rest.comum.RequisicaoRestPadrao#getServico()
	 */
	@Override
	public CrudPadraoServico getServico() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
