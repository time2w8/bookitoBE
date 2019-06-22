package pe.com.fas.bookito.service;

import pe.com.fas.bookito.model.Universidad;

public interface IUniversidadService extends IService<Universidad>{
	Universidad findByCodigo(String codigo);
}
