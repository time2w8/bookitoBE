package pe.com.fas.bookito.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bookitos")
public class Bookito implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private String autor;
	
	@NotNull
	private String contenido;
	
	@NotNull
	private Boolean ebook;
	
	private String imgUrl;
	
	private String moreUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Boolean getEbook() {
		return ebook;
	}

	public void setEbook(Boolean ebook) {
		this.ebook = ebook;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getMoreUrl() {
		return moreUrl;
	}

	public void setMoreUrl(String moreUrl) {
		this.moreUrl = moreUrl;
	}
	
}
