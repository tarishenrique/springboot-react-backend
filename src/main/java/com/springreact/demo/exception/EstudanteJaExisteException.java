package com.springreact.demo.exception;

public class EstudanteJaExisteException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EstudanteJaExisteException(String mensagem) {
		super(mensagem);
	}

}
