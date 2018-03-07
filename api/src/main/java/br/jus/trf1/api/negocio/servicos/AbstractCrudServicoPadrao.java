package br.jus.trf1.api.negocio.servicos;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import br.jus.trf1.api.excecoes.NegocioException;
import br.jus.trf1.api.excecoes.PersistenciaException;
import br.jus.trf1.api.negocio.servicos.comum.CrudPadraoServico;
import br.jus.trf1.api.persistencia.dao.comum.PersistenciaPadraoDao;

/**
 * Classe abstrata com os métodos padrões para os serviços
 * @author wallace
 *
 * @param <T>
 * @param <V>
 */
@Transactional(value=TxType.REQUIRED)
@SuppressWarnings({"rawtypes", "unchecked"})
@Named
@Dependent
public abstract class AbstractCrudServicoPadrao<T> implements CrudPadraoServico<T> {

	private PersistenciaPadraoDao<T> dao;

	private java.util.logging.Logger log = java.util.logging.Logger.getLogger(getClass().getName());
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	@PostConstruct
	private void init() throws Exception {
	}


	protected abstract Class getClasseEntidade();
		//return (Class) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	

	
	@Transactional(value=TxType.REQUIRES_NEW)	
	public void incluir(T objeto) throws NegocioException {
		try {
			objeto = getDao().incluir(objeto);
		} catch (PersistenciaException e) {
			throw new NegocioException(e);
		}

	}


	@Override
	@Transactional(value=TxType.REQUIRES_NEW)		
	public void alterar(T objeto) throws NegocioException {
		try {
			getDao().alterar((objeto));
		} catch (PersistenciaException e) {
			throw new NegocioException(e);
		}

	}

	@Override
	@Transactional(value=TxType.REQUIRES_NEW)		
	public void excluir(Serializable id) throws NegocioException {
		
		try {
			T objeto = getDao().find(id);
			getDao().excluir(objeto);
		} catch (PersistenciaException e) {
			throw new NegocioException(e);
		}

	}

	@Override
	public void alterar(List<T> objetos) throws NegocioException {
		for(T obj : objetos){
			this.alterar(obj);
		}
	}
	
	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)	
	public T find(Serializable id) throws NegocioException {
        try {
            return getDao().find(id);
        } catch (PersistenciaException e) {
            throw new NegocioException(e);
        }
    }
	


	@Transactional(value=TxType.NOT_SUPPORTED)	
	@Override
	public List<T> listarTudo() throws NegocioException {
        try {
            return getDao().listar();
        } catch (PersistenciaException e) {
            throw new NegocioException(e);

        }
    }

	protected Logger getLogger(){
		return log;
	}


	public PersistenciaPadraoDao<T> getDao() {
		return dao;
	}


	public void setDao(PersistenciaPadraoDao<T> dao) {
		this.dao = dao;
	}


	
}
