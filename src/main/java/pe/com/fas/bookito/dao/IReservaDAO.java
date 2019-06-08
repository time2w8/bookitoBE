package pe.com.fas.bookito.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.fas.bookito.model.Reserva;

public interface IReservaDAO extends JpaRepository<Reserva, Long>{

}
