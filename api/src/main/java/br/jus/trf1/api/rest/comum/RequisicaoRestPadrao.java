package br.jus.trf1.api.rest.comum;


import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.jus.trf1.api.excecoes.NegocioException;
import br.jus.trf1.api.excecoes.WebServiceException;
import br.jus.trf1.api.negocio.servicos.comum.CrudPadraoServico;
import br.jus.trf1.api.tokens.TokenManager;
import br.jus.trf1.api.utilitarios.Constantes;

@Produces(value={MediaType.APPLICATION_JSON})
@Dependent
public abstract class RequisicaoRestPadrao<T> implements ContratoPadraoRest  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected java.util.logging.Logger log = Logger.getLogger(this.getClass().getName());

	@Context
	private HttpHeaders headers;
	
	private HttpServletRequest request;
	
	private CrudPadraoServico<T> servico;
	
	@PostConstruct
	public void init(){
		//executado antes do web service e depois do interceptor
		log.info("Init do método requisicao rest padrao"); 
	}
	
	
	public HttpHeaders getHeaders() {
		return headers;
	}

	public abstract CrudPadraoServico<T> getServico();

	
	/* (non-Javadoc)
	 * @see br.net.walltec.api.rest.webservices.ContratoPadraoRest#novo()
	 */
	@Override
	public Response novo() throws WebServiceException {
		return Response.ok().build();
	}

	/* (non-Javadoc)
	 * @see br.net.walltec.api.rest.webservices.ContratoPadraoRest#procurar(java.lang.Integer)
	 */
	@Override
	public Response procurar(Integer idProcura) throws WebServiceException {
		// TODO Auto-generated method stub
		try {
			return Response.ok().entity(getServico().find(idProcura)).build();
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			throw new WebServiceException(e.getMessage());
		}
	}


	/* (non-Javadoc)
	 * @see br.net.walltec.api.rest.webservices.ContratoPadraoRest#listar()
	 */
	@Override
	public Response listar() throws WebServiceException {
		try {
			return Response.ok(getServico().listarTudo()).build();
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			throw new WebServiceException(e.getMessage());
		}
	}
	
	public synchronized Integer getIdUsuarioLogado(){
		String token = getHeaders().getHeaderString(Constantes.TAG_TOKEN);
		String subject = new TokenManager().getSubject(token);
		String[] dados = subject.split("@");
		return Integer.valueOf(dados[0]);
		
	}

	
}
