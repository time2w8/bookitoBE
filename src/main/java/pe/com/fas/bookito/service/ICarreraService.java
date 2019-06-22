package pe.com.fas.bookito.service;

import pe.com.fas.bookito.model.Carrera;

public interface ICarreraService extends IService<Carrera> {
	Carrera findByCodigo(String codigo);
}
