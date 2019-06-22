package pe.com.fas.bookito.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.fas.bookito.model.Carrera;

public interface ICarreraDAO extends JpaRepository<Carrera, Long>{
	Carrera findByCodigo(String codigo);
}
