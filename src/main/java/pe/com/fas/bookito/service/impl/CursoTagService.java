package pe.com.fas.bookito.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.fas.bookito.dao.ICursoTagDAO;
import pe.com.fas.bookito.model.CursoTag;
import pe.com.fas.bookito.service.ICursoTagService;

@Service
public class CursoTagService implements ICursoTagService {

	@Autowired
	private ICursoTagDAO dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<CursoTag> findAll() {
		// TODO Auto-generated method stub
		return (List<CursoTag>) dao.findAll();
	}

	@Override
	@Transactional
	public void save(CursoTag t) {
		// TODO Auto-generated method stub
		dao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public CursoTag findOne(Long id) {
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
	public Page<CursoTag> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
