package pe.com.fas.bookito.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import pe.com.fas.bookito.model.compositekey.UsuarioCursoKey;

@Entity
@Table(name = "usuario_cursos")
public class UsuarioCurso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuarioCursoKey id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("usuario_id")
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("curso_id")
	@JoinColumn(name = "curso_id")
	private Curso curso;

	public UsuarioCursoKey getId() {
		return id;
	}

	public void setId(UsuarioCursoKey id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
}
