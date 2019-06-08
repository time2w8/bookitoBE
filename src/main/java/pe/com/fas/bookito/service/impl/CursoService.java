package pe.com.fas.bookito.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.fas.bookito.dao.ICursoDAO;
import pe.com.fas.bookito.model.Curso;
import pe.com.fas.bookito.service.ICursoService;

@Service
public class CursoService implements ICursoService {

	@Autowired
	private ICursoDAO cursoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Curso> findAll() {
		// TODO Auto-generated method stub
		return (List<Curso>) cursoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Curso t) {
		// TODO Auto-generated method stub
		cursoDao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Curso findOne(Long id) {
		// TODO Auto-generated method stub
		return cursoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		cursoDao.deleteById(id);
	}

	@Override
	public Page<Curso> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
