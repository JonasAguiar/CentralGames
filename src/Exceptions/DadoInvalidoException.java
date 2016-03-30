package Exceptions;

public class DadoInvalidoException extends Exception {

	public DadoInvalidoException(){
		super("Dado especificado eh invalido");
	}
	
	public DadoInvalidoException(String mensagem){
		super(mensagem);
	}
	
}
