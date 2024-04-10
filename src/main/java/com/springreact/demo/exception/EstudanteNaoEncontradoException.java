package com.springreact.demo.exception;

public class EstudanteNaoEncontradoException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EstudanteNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

}
