package br.jus.trf1.api.excecoes;

public class PersistenciaException extends Exception {

	private static final long serialVersionUID = 1L;

	public PersistenciaException(String message) {
		super(message);
	}

	public PersistenciaException(String message, Throwable cause) {
		super(message, cause);
	}

	public PersistenciaException(Throwable cause) {
		super(cause);
	}
}
