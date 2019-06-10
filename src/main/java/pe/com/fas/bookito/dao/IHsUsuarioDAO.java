package pe.com.fas.bookito.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.fas.bookito.model.HsUsuario;

public interface IHsUsuarioDAO extends JpaRepository<HsUsuario, Long>{
	HsUsuario findByEmail(String email);
	HsUsuario findByCodigo(String codigo);
}
