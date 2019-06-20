package pe.com.fas.bookito.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.fas.bookito.model.Repositorio;

public interface IRepositorioDAO extends JpaRepository<Repositorio, Long> {

}
