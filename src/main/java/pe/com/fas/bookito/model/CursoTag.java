package pe.com.fas.bookito.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import pe.com.fas.bookito.model.compositekey.CursoTagKey;

@Entity
@Table(name = "curso_tags")
public class CursoTag implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CursoTagKey id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("curso_id")
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("tag_id")
	@JoinColumn(name = "tag_id")
	private Tag tag;

	public CursoTagKey getId() {
		return id;
	}

	public void setId(CursoTagKey id) {
		this.id = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
	
}
