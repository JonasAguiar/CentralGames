package Operacional;

import Usuario.Usuario;
import Usuario.Veterano;

public class FactoryUsuario {
	
	
	public Usuario criaUsuario(String tipoUsuario, String nomeUsuario, String id) throws Exception{
		if(tipoUsuario == null){
			throw new Exception("Nao pode ser criado usuario nulo.");
		}
		if(tipoUsuario.equals("Rpg")){
			Usuario usuario = new Veterano(nomeUsuario, id);
			return usuario;
		}else if(tipoUsuario.equals("Noob")){
			Usuario usuario = new Veterano(nomeUsuario, id);
			return usuario;
		}
		return null;
		
	}

}
