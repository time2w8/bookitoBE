package pe.com.fas.bookito.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.fas.bookito.dao.ICarreraDAO;
import pe.com.fas.bookito.model.Carrera;
import pe.com.fas.bookito.service.ICarreraService;

@Service
public class CarreraService implements ICarreraService {

	@Autowired
	private ICarreraDAO dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Carrera> findAll() {
		// TODO Auto-generated method stub
		return (List<Carrera>) dao.findAll();
	}

	@Override
	@Transactional
	public void save(Carrera t) {
		// TODO Auto-generated method stub
		dao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Carrera findOne(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public Page<Carrera> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
