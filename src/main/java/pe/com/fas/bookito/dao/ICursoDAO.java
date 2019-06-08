package pe.com.fas.bookito.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.fas.bookito.model.Curso;

public interface ICursoDAO extends JpaRepository<Curso, Long>{

}
