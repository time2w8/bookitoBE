package pe.com.fas.bookito.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//Prueba para seguridad TO-DO
@Entity
@Table(name = "hs_usuarios")
public class HsUsuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String password;
	
	@NotNull
	private Date lastLogin;
	
	@NotNull
	private String status;
	
	@NotNull
	private Long intentos;
	
	
	@NotNull
	private String código;
	
	@NotNull
	private Boolean esAlumno;
	
	@NotNull
	private int active;
	
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getIntentos() {
		return intentos;
	}

	public void setIntentos(Long intentos) {
		this.intentos = intentos;
	}

	public String getCódigo() {
		return código;
	}

	public void setCódigo(String código) {
		this.código = código;
	}

	public Boolean getEsAlumno() {
		return esAlumno;
	}

	public void setEsAlumno(Boolean esAlumno) {
		this.esAlumno = esAlumno;
	}
	
}
