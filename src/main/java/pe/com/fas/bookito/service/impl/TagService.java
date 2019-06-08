package pe.com.fas.bookito.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.fas.bookito.dao.ITagDao;
import pe.com.fas.bookito.model.Tag;
import pe.com.fas.bookito.service.ITagService;

@Service
public class TagService implements ITagService {

	@Autowired
	private ITagDao dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Tag> findAll() {
		// TODO Auto-generated method stub
		return (List<Tag>) dao.findAll();
	}

	@Override
	@Transactional
	public void save(Tag t) {
		// TODO Auto-generated method stub
		dao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Tag findOne(Long id) {
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
	public Page<Tag> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
