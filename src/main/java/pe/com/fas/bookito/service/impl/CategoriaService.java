package pe.com.fas.bookito.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.fas.bookito.dao.ICategoriaDAO;
import pe.com.fas.bookito.model.Categoria;
import pe.com.fas.bookito.service.ICategoriaService;

@Service
public class CategoriaService implements ICategoriaService {

	@Autowired
	private ICategoriaDAO dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return (List<Categoria>) dao.findAll();
	}

	@Override
	@Transactional
	public void save(Categoria t) {
		// TODO Auto-generated method stub
		dao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Categoria findOne(Long id) {
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
	public Page<Categoria> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
