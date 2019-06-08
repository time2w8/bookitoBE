package pe.com.fas.bookito.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.fas.bookito.dao.IUsuarioCursoDAO;
import pe.com.fas.bookito.model.UsuarioCurso;
import pe.com.fas.bookito.service.IUsuarioCursoService;

@Service
public class UsuarioCursoService implements IUsuarioCursoService {

	@Autowired
	private IUsuarioCursoDAO dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<UsuarioCurso> findAll() {
		// TODO Auto-generated method stub
		return (List<UsuarioCurso>) dao.findAll();
	}

	@Override
	@Transactional
	public void save(UsuarioCurso t) {
		// TODO Auto-generated method stub
		dao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public UsuarioCurso findOne(Long id) {
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
	public Page<UsuarioCurso> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


}
