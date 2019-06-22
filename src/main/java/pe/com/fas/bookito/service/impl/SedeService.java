package pe.com.fas.bookito.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.fas.bookito.dao.ISedeDAO;
import pe.com.fas.bookito.model.Sede;
import pe.com.fas.bookito.service.ISedeService;

@Service
public class SedeService implements ISedeService {

	@Autowired
	private ISedeDAO dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Sede> findAll() {
		// TODO Auto-generated method stub
		return (List<Sede>) dao.findAll();
	}

	@Override
	@Transactional
	public void save(Sede t) {
		// TODO Auto-generated method stub
		dao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Sede findOne(Long id) {
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
	public Page<Sede> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sede findByCodigo(String codigo) {
		// TODO Auto-generated method stub
		return dao.findByCodigo(codigo);
	}

}
