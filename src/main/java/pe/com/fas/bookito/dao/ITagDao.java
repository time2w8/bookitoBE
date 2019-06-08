package pe.com.fas.bookito.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.fas.bookito.model.Tag;

public interface ITagDao extends JpaRepository<Tag, Long>{

}
