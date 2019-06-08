package pe.com.fas.bookito.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.fas.bookito.model.Categoria;

public interface ICategoriaDAO extends JpaRepository<Categoria, Long>{

}
