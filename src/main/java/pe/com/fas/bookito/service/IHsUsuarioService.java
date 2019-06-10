package pe.com.fas.bookito.service;

import pe.com.fas.bookito.model.HsUsuario;

public interface IHsUsuarioService extends IService<HsUsuario> {
	HsUsuario findByEmail(String email);
	HsUsuario findByCodigo(String codigo);
}
