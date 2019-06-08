package pe.com.fas.bookito.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IService<T> {
	
	public List<T> findAll();

	public void save(T t);

	public T findOne(Long id);

	public void delete(Long id);
	
	public Page<T> findAll(Pageable pageable);
	
}
