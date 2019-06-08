package pe.com.fas.bookito.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.fas.bookito.model.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long>{

}
