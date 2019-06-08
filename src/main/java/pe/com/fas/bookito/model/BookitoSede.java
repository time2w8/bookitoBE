package pe.com.fas.bookito.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import pe.com.fas.bookito.model.compositekey.BookitoSedeKey;

@Entity
@Table(name = "bookitos_sede")
public class BookitoSede implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BookitoSedeKey id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("bookito_id")
	@JoinColumn(name = "bookito_id")
	private Bookito bookito;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("sede_id")
	@JoinColumn(name = "sede_id")
	private Sede sede;
	
	@NotNull
	private int disponibles;
	
	@NotNull
	private Date fecha_disponible;

	public BookitoSedeKey getId() {
		return id;
	}

	public void setId(BookitoSedeKey id) {
		this.id = id;
	}

	public Bookito getBookito() {
		return bookito;
	}

	public void setBookito(Bookito bookito) {
		this.bookito = bookito;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public int getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(int disponibles) {
		this.disponibles = disponibles;
	}

	public Date getFecha_disponible() {
		return fecha_disponible;
	}

	public void setFecha_disponible(Date fecha_disponible) {
		this.fecha_disponible = fecha_disponible;
	}
	
}
