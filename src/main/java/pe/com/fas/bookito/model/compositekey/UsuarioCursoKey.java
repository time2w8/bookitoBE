package pe.com.fas.bookito.model.compositekey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioCursoKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "curso_id")
	Long cursoId;
	
	@Column(name = "usuario_id")
	Long usuarioId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cursoId == null) ? 0 : cursoId.hashCode());
		result = prime * result + ((usuarioId == null) ? 0 : usuarioId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioCursoKey other = (UsuarioCursoKey) obj;
		if (cursoId == null) {
			if (other.cursoId != null)
				return false;
		} else if (!cursoId.equals(other.cursoId))
			return false;
		if (usuarioId == null) {
			if (other.usuarioId != null)
				return false;
		} else if (!usuarioId.equals(other.usuarioId))
			return false;
		return true;
	}

	public Long getCursoId() {
		return cursoId;
	}

	public void setCursoId(Long cursoId) {
		this.cursoId = cursoId;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	
}
