package pe.com.fas.bookito.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.fas.bookito.dao.IBookitoDAO;
import pe.com.fas.bookito.model.Bookito;
import pe.com.fas.bookito.service.IBookitoService;

@Service
public class BookitoService implements IBookitoService {

	@Autowired
	private IBookitoDAO dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Bookito> findAll() {
		// TODO Auto-generated method stub
		return (List<Bookito>) dao.findAll();
	}

	@Override
	@Transactional
	public void save(Bookito t) {
		// TODO Auto-generated method stub
		dao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Bookito findOne(Long id) {
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
	public Page<Bookito> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
