package Exceptions;

public class ConversaoInvalidaException extends Exception {

	public ConversaoInvalidaException() {
		super();
	}

	public ConversaoInvalidaException(String mensagem) {
		super(mensagem);
	}
}