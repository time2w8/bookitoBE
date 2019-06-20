package pe.com.fas.bookito.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.fas.bookito.dao.IRepositorioDAO;
import pe.com.fas.bookito.model.Repositorio;
import pe.com.fas.bookito.service.IRepositorioService;

@Service
public class RepositorioService implements IRepositorioService {

	@Autowired
	private IRepositorioDAO dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Repositorio> findAll() {
		// TODO Auto-generated method stub
		return (List<Repositorio>) dao.findAll();
	}

	@Override
	@Transactional
	public void save(Repositorio t) {
		// TODO Auto-generated method stub
		dao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Repositorio findOne(Long id) {
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
	public Page<Repositorio> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
