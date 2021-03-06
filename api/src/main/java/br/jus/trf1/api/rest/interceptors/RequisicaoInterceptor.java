package br.jus.trf1.api.rest.interceptors;



import java.util.logging.Logger;

import javax.inject.Named;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response.Status;

import br.jus.trf1.api.excecoes.WebServiceException;
import br.jus.trf1.api.rest.comum.RequisicaoRestPadrao;
import br.jus.trf1.api.tokens.TokenManager;
import br.jus.trf1.api.utilitarios.Constantes;


@Named
@Interceptor

/**
 * Interceptador para todas as requisições
 * */
public class RequisicaoInterceptor {

	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@SuppressWarnings("rawtypes")
	@AroundInvoke
	public Object verificarRequisicao(InvocationContext contexto) throws Exception {
		log.info("Executando interceptor no método " + contexto.getMethod().getName() + " classe: " + contexto.getClass().getName());
		
		if (contexto.getTarget() != null){
			HttpHeaders headers = ((RequisicaoRestPadrao)contexto.getTarget()).getHeaders();
		
			String token = headers.getHeaderString(Constantes.TAG_TOKEN);
			
	        headers.getRequestHeaders().add("Access-Control-Allow-Origin", "http://localhost:4200");
	        headers.getRequestHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
			
	       // boolean ehLogin = contexto.getMethod().getName().equalsIgnoreCase("efetuarLogin");
			//validarToken(token, ehLogin);
			
		}
		
		
		Object objeto = contexto.proceed();
		log.info("Finalizando interceptor");

		return objeto;
	}

	/**
	 * @param token
	 * @param ehLogin
	 */
	private void validarToken(String token, boolean ehLogin) {
		if (!ehLogin && naoHaToken(token) ){
			throw new WebServiceException(Status.UNAUTHORIZED);
		}
		
		if (!ehLogin &&  !new TokenManager().isTokenValido(token)){
			throw new WebServiceException(Status.FORBIDDEN);
		}
	}
	
	private boolean naoHaToken(String token){
		return token == null || token.isEmpty();		
	}
}
