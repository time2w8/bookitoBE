package pe.com.fas.bookito.service;

import pe.com.fas.bookito.model.Usuario;

public interface IUsuarioService extends IService<Usuario> {
	Usuario findByEmail(String email);
	Usuario findByCodigo(String codigo);
}
