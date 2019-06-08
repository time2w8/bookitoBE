package pe.com.fas.bookito.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "reservas")
public class Reserva implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Date fechaEntrega;
	
	@NotNull
	private Date fechaRecojo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuario;
	
	@NotNull
	private String estado;
	
	@NotNull
	private Long penalizacion;
		
	@ManyToOne(fetch = FetchType.EAGER)
	BookitoSede bookitoSede;

	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Date getFechaRecojo() {
		return fechaRecojo;
	}

	public void setFechaRecojo(Date fechaRecojo) {
		this.fechaRecojo = fechaRecojo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getPenalizacion() {
		return penalizacion;
	}

	public void setPenalizacion(Long penalizacion) {
		this.penalizacion = penalizacion;
	}

	public BookitoSede getBookitoSede() {
		return bookitoSede;
	}

	public void setBookitoSede(BookitoSede bookitoSede) {
		this.bookitoSede = bookitoSede;
	}
	
}
