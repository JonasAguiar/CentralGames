package Operacional;

import Usuario.Usuario;
import Usuario.Veterano;

public class FactoryUsuario {
	
	/**
	 * O metodo é uma fabrica de usuarios, usado para criacao deles.
	 * @param tipoUsuario
	 * @param nomeUsuario
	 * @param id
	 * @return
	 * @throws Exception
	 */
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
