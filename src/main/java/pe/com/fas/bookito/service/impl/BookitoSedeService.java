package pe.com.fas.bookito.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.fas.bookito.dao.IBookitoSedeDAO;
import pe.com.fas.bookito.model.BookitoSede;
import pe.com.fas.bookito.service.IBookitoSedeService;

@Service
public class BookitoSedeService implements IBookitoSedeService {

	@Autowired
	private IBookitoSedeDAO dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<BookitoSede> findAll() {
		// TODO Auto-generated method stub
		return (List<BookitoSede>) dao.findAll();
	}

	@Override
	@Transactional
	public void save(BookitoSede t) {
		// TODO Auto-generated method stub
		dao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public BookitoSede findOne(Long id) {
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
	public Page<BookitoSede> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
