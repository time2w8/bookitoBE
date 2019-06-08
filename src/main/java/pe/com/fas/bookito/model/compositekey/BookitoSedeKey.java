package pe.com.fas.bookito.model.compositekey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookitoSedeKey implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "bookito_id")
	Long bookitoId;
	
	@Column(name = "sede_id")
	Long sedeId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookitoId == null) ? 0 : bookitoId.hashCode());
		result = prime * result + ((sedeId == null) ? 0 : sedeId.hashCode());
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
		BookitoSedeKey other = (BookitoSedeKey) obj;
		if (bookitoId == null) {
			if (other.bookitoId != null)
				return false;
		} else if (!bookitoId.equals(other.bookitoId))
			return false;
		if (sedeId == null) {
			if (other.sedeId != null)
				return false;
		} else if (!sedeId.equals(other.sedeId))
			return false;
		return true;
	}

	public Long getBookitoId() {
		return bookitoId;
	}

	public void setBookitoId(Long bookitoId) {
		this.bookitoId = bookitoId;
	}

	public Long getSedeId() {
		return sedeId;
	}

	public void setSedeId(Long sedeId) {
		this.sedeId = sedeId;
	}
	
}
