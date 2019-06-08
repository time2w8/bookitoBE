package pe.com.fas.bookito.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.fas.bookito.model.Bookito;

public interface IBookitoDAO extends JpaRepository<Bookito, Long>{

}
