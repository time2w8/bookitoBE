package pe.com.fas.bookito.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.fas.bookito.dao.IHsUsuarioDAO;
import pe.com.fas.bookito.model.HsUsuario;
import pe.com.fas.bookito.service.IHsUsuarioService;

@Service
public class HsUsuarioService implements IHsUsuarioService {

	@Autowired
	private IHsUsuarioDAO dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<HsUsuario> findAll() {
		// TODO Auto-generated method stub
		return (List<HsUsuario>) dao.findAll();
	}

	@Override
	@Transactional
	public void save(HsUsuario t) {
		// TODO Auto-generated method stub
		dao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public HsUsuario findOne(Long id) {
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
	public Page<HsUsuario> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HsUsuario findByEmail(String email) {
		// TODO Auto-generated method stub
		return dao.findByEmail(email);
	}

	@Override
	public HsUsuario findByCodigo(String codigo) {
		// TODO Auto-generated method stub
		return dao.findByCodigo(codigo);
	}

}
