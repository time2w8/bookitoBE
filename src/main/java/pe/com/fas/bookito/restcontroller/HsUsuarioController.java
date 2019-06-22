package pe.com.fas.bookito.restcontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.google.gson.JsonObject;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pe.com.fas.bookito.model.Carrera;
import pe.com.fas.bookito.model.HsUsuario;
import pe.com.fas.bookito.model.Sede;
import pe.com.fas.bookito.model.Usuario;
import pe.com.fas.bookito.service.ICarreraService;
import pe.com.fas.bookito.service.IHsUsuarioService;
import pe.com.fas.bookito.service.ISedeService;
import pe.com.fas.bookito.service.IUniversidadService;
import pe.com.fas.bookito.service.IUsuarioService;
import pe.com.fas.bookito.service.impl.MyUserDetailsService;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "*")
public class HsUsuarioController {

	@Autowired
	private IHsUsuarioService service;
	
	@Autowired
	private IUsuarioService serviceUsuario;
	
	@Autowired
	private IUniversidadService serviceUniversidad;
	
	@Autowired
	private ICarreraService serviceCarrera;
	
	@Autowired
	private ISedeService serviceSede;
	
	@Autowired
	private MyUserDetailsService security;

	@Autowired
	private PasswordEncoder encoder;

	@ApiOperation(value = "Obtener lista de HsUsuarios", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/api/v1/hs_usuario")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HsUsuario> getHsUsuarios() {
		List<HsUsuario> list = new ArrayList<HsUsuario>();
		try {
			list = service.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@ApiOperation(value = "Obtener HsUsuario por ID", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/api/v1/hs_usuario/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public HsUsuario getHsUsuario(@PathVariable("id") Long id) {
		HsUsuario HsUsuario = new HsUsuario();
		try {
			HsUsuario = service.findOne(id);
			return HsUsuario;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@ApiOperation(value = "Inicio de sesión")
	@Produces(MediaType.APPLICATION_JSON)
	@PostMapping("/login")
	public HsUsuario login(@RequestBody HsUsuario obj) {
		HsUsuario user = service.findByCodigo(obj.getCodigo());
		if(user == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe");
		}

		if (encoder.matches(obj.getPassword(), user.getPassword())) {
			UserDetails sessionUser = security.loadUserByUsername(user.getCodigo());
			if(sessionUser == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe");
			}
			user.setLastLogin(new Date());
			user.setIntentos(new Long(0));
			service.save(user);
			return user;
		}
		user.setIntentos(user.getIntentos() + 1);
		service.save(user);
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La contraseña es incorrecta");
	}
	
	@ApiOperation(value = "Comprobar código existente", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping("/checkCodigo")
	@Produces(MediaType.APPLICATION_JSON)
	public HttpStatus checkCodigo(@RequestBody String codigo) {
	
		
		if(service.findByCodigo(codigo) == null) {
			return HttpStatus.OK;
		}else {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Ya existe un usuario con ese codigo.");
		}
		
	}
	
	@ApiOperation(value = "Comprobar email existente", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping("/checkEmail")
	@Produces(MediaType.APPLICATION_JSON)
	public HttpStatus checkEmail(@RequestBody String email) {
	
		if(service.findByEmail(email) == null) {
			return HttpStatus.OK;
		}else {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Ya existe un usuario con ese email.");
		}
		
	}

	@ApiOperation(value = "Registro de usuario", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public HsUsuario save(HttpSession session,@RequestBody HsUsuario HsUsuario) {
		
		String codigoCarrera = HsUsuario.getUsuario().getCarrera().getCodigo();
		String codigoSede = HsUsuario.getUsuario().getSede().getCodigo();
		String codigoUniversidad = HsUsuario.getUsuario().getSede().getUniversidad().getCodigo();
		
		Long idCarrera = serviceCarrera.findByCodigo(codigoCarrera).getId();
		Long idSede = serviceSede.findByCodigo(codigoSede).getId();
		
		Carrera carrera = new Carrera();
		carrera.setId(idCarrera);
		Sede sede = new Sede();
		sede.setId(idSede);
		
		HsUsuario.setIntentos(new Long(0));
		HsUsuario.setLastLogin(new Date());
		HsUsuario.setPassword(encoder.encode(HsUsuario.getPassword()));
		Usuario userData =  new Usuario();
		userData = HsUsuario.getUsuario();
		userData.setCarrera(carrera);
		userData.setSede(sede);
		HsUsuario.setUsuario(userData);
		//user = service.findByCodigo(HsUsuario.getCodigo());
		//return user;
		try {
			service.save(HsUsuario);
			try {
				this.serviceUsuario.save(userData);
				return HsUsuario;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.print(e);
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrió un error inesperado.");
			}		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrió un error inesperado.");
		}
		/*
		if(user != null) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Ya existe un usuario con ese código.");
		}else {
			user = null;
			user = service.findByEmail(HsUsuario.getEmail());
			if(user != null) {
				throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Ya existe un usuario con ese email.");
			}else {
				try {
					service.save(HsUsuario);
					return HsUsuario;
				} catch (Exception e) {
					// TODO: handle exception
					throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrió un error inesperado.");
				}
			}
		}*/		
	}

	@ApiOperation(value = "Actualizar un HsUsuario por ID", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PutMapping("/api/v1/hs_usuario/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody HsUsuario HsUsuario) {
		HsUsuario obj = new HsUsuario();
		obj = service.findOne(id);
		if (obj != null) {
			try {
				service.save(HsUsuario);
				return new ResponseEntity<>("HsUsuario actualizado correctamente", HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>("No se pudo actualizar HsUsuario", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<>("No se pudo encontrar el HsUsuario", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Eliminar un HsUsuario por ID", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@DeleteMapping("/api/v1/hs_usuario/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		try {
			service.delete(id);
			return new ResponseEntity<>("El HsUsuario ha sido eliminado con éxito", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No se pudo eliminar el HsUsuario", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
