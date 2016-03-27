package laboratorio6;

public class FactoryUsuario {

	
	public Usuario getUsuario(String tipoUsuario, String nomeUsuario, String idUsuario) throws Exception{
		if(tipoUsuario == null){
			throw new Exception("Nao pode ser criado usuario nulo.");
		}
		if(tipoUsuario.equals("Noob")){
			Usuario novoUsuario = new Veterano(nomeUsuario, idUsuario);
			return novoUsuario;
		}
		return null;
	}
	
	
}
