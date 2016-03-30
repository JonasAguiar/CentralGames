package Exceptions;

public class EntradaInvalidaException extends Exception {

	public EntradaInvalidaException(){
		super();
	}
	
	public EntradaInvalidaException(String mensagem){
		super(mensagem);
	}
	
}
