package br.jus.trf1.api.negocio.servicos.comum;


import java.io.Serializable;
import java.util.List;

import br.jus.trf1.api.excecoes.NegocioException;


 /**
  * Interface padrao para os cruds do sistema
 * @author wallace
 *
 * @param <T>
 * @param <V>
 */
public interface CrudPadraoServico<T> {

	 void incluir(T objeto) throws NegocioException;
	 
	 void alterar(T objeto) throws NegocioException;
	 
	 void excluir(Serializable id) throws NegocioException;
	 
	 T find(Serializable id) throws NegocioException;

	 void alterar(List<T> objetos) throws NegocioException;
	 
	 void incluir(List<T> objetos) throws NegocioException;
	 
	 List<T> listarTudo() throws NegocioException;	
}
