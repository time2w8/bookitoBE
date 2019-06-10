package pe.com.fas.bookito.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.fas.bookito.dao.IUsuarioDAO;
import pe.com.fas.bookito.model.Usuario;
import pe.com.fas.bookito.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuarioDAO dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) dao.findAll();
	}

	@Override
	@Transactional
	public void save(Usuario t) {
		// TODO Auto-generated method stub
		dao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findOne(Long id) {
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
	public Page<Usuario> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
